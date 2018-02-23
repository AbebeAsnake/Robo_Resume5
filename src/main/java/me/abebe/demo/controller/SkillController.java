package me.abebe.demo.controller;

import me.abebe.demo.model.ApplicantSkill;
import me.abebe.demo.model.User;
import me.abebe.demo.repo.ApplicantSkillRepository;
import me.abebe.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SkillController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ApplicantSkillRepository applicantSkillRepository;
    @RequestMapping("/addskill")
    private String postSkill(@Valid ApplicantSkill skill, BindingResult result, Authentication principal){

        User user = userRepository.findByUserName(principal.getName());

        if(result.hasErrors()){
            return "addjobs";
        }
        //job.setPostedDate(new Date());
        skill.setPersonId(user.getUserName());
        System.out.println(user.getUserName());
        applicantSkillRepository.save(skill);

        return "redirect:/addjobs";
    }
    @GetMapping("/addskill")
    public String skilladd(Model model){
        model.addAttribute("skillss", new ApplicantSkill());
        return "addskill";
    }
}
