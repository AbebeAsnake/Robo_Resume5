package me.abebe.demo.controller;

import me.abebe.demo.model.ApplicantSkill;
import me.abebe.demo.model.User;
import me.abebe.demo.repo.ApplicantSkillRepository;
import me.abebe.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class SkillController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ApplicantSkillRepository applicantSkillRepository;
    @RequestMapping(path="/addskills", method= RequestMethod.POST)
    private String postskill(@Valid ApplicantSkill skill, BindingResult bindingResult,
                           Principal principal, Model model){

        User user = userRepository.findByUserName(principal.getName());

        if(bindingResult.hasErrors()){
            return "addjobs";
        }
        //job.setPostedDate(new Date());
        skill.setPersonId(user.getFirstName());
        applicantSkillRepository.save(skill);


        return "addskill";

    }
    @RequestMapping(path="/addskill", method =RequestMethod.GET)
    public String skilladd(Model model){
        model.addAttribute("skillss", new ApplicantSkill());
        return "addskill";
    }
}
