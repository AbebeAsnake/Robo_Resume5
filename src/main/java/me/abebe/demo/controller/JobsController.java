package me.abebe.demo.controller;

import me.abebe.demo.model.DesiredSkills;
import me.abebe.demo.model.Jobs;
import me.abebe.demo.model.User;
import me.abebe.demo.repo.DesiredSkillsRepository;
import me.abebe.demo.repo.JobsRepository;
import me.abebe.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JobsController {
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    DesiredSkillsRepository desiredSkillsRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path="/addjobs",method= RequestMethod.GET)
    public String addJob(Model model){
        model.addAttribute("job", new Jobs());
        return "addjobs";
    }
    @RequestMapping(path="/addjobs", method=RequestMethod.POST)
    private String postJob(@Valid Jobs job, BindingResult bindingResult,
                           Principal principal, Model model){

        User user = userRepository.findByUserName(principal.getName());

        if(bindingResult.hasErrors()){
            return "addjobs";
        }
        //job.setPostedDate(new Date());
        job.setPostedBy(user.getFirstName());
        jobsRepository.save(job);

        List<Jobs> j = jobsRepository.findByPostedBy(user.getFirstName());
        int i = j.size();
        Jobs jobatIndex = j.get(i-1);
        model.addAttribute("jobId",jobatIndex.getJobId());
        model.addAttribute("skills", new DesiredSkills());
        return "adddesiredSkills";

    }
    @RequestMapping(path="/job/skill/{jobId}")
    private String postJob(@PathVariable("jobId")Long jobId, ArrayList<DesiredSkills> skList, Model model){

        model.addAttribute("jobId", jobId);
        model.addAttribute("skillList",skList);
        model.addAttribute("skills", new DesiredSkills());
        return "adddesiredSkills";
    }

    @RequestMapping(path="/job/skill", method=RequestMethod.POST)
    private String addSkillToJob(@Valid DesiredSkills skill, BindingResult bindingResult,Long jobId, Principal principal, Model model  ){


        ArrayList<DesiredSkills> skills =  new ArrayList<DesiredSkills>();
        User user = userRepository.findByUserName(principal.getName());

        if(bindingResult.hasErrors()){
            return "jobskillForm";
        }
        skill.setJob(jobsRepository.findOne(jobId));
        desiredSkillsRepository.save(skill);
        skills.add(skill);
        model.addAttribute("jobId", jobId);
        model.addAttribute("skList", skills);
        return "jobdesiredskill";
    }

    @RequestMapping(path="/alljobs")
    private String allJobs(Model model){

        Iterable<Jobs> jobs = jobsRepository.findAll();

        model.addAttribute("jobs", jobs);
        return "joblist";
    }
    @RequestMapping(path="/jobsearch/{organization}")
    private String searchByCompany(@PathVariable("organization")String organization, Model model){
       // List<Jobs> jobList = jobsRepository.findDistinctByOrganization(organization);
        model.addAttribute("joblist", jobsRepository.findDistinctByOrganization(organization));
        return "showsearch";
    }
    @RequestMapping(path="/jobsearch")
    private String searchByCompany( Model model){

        model.addAttribute("joblists",jobsRepository.findAll());
        return "searchbyorganization";
    }
    @RequestMapping("/sayhi")
private String userJob(Model model,Principal principal){
        User user = userRepository.findByUserName(principal.getName().toString());
        System.out.println(user);
        return "redirect:/jobsearch";
}
}
