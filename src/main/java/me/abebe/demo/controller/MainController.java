package me.abebe.demo.controller;

import me.abebe.demo.model.Applicant;
import me.abebe.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    ApplicantRepository applicantRepository;
@Autowired
    ApplicantSkillRepository applicantSkillRepository;
@Autowired
    EducationRepository educationRepository;
@Autowired
    WorkExperienceRepository workExperienceRepository;
@Autowired
    ReferencesRepository referencesRepository;
@Autowired
SummaryRepository summaryRepository;


    @RequestMapping("/displayresume")
    public String DiplayResume(Model model){
        model.addAttribute("person",applicantRepository.findAll());
        model.addAttribute("skills",applicantSkillRepository.findAll());
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("workexprience", workExperienceRepository.findAll());
        //model.addAttribute("reference", referencesRepository.findAll());
        model.addAttribute("summary", summaryRepository.findAll());

        return "displayresume";
    }
    @GetMapping("/postp")
    public  String postProcess(Model model){
        model.addAttribute("person",new Applicant());
        model.addAttribute("personforms",applicantRepository.findAll());
        return "addapplicant";
    }
    @PostMapping("/postp")
    public  String processForm(@Valid @ModelAttribute Applicant person, BindingResult result){
        if(result.hasErrors()){
            return "addapplicant";
        }
        applicantRepository.save(person);
        return "redirect:/displayresume";
    }
    @RequestMapping("/login")
    public String showLogin(Model model){

        return "login";
    }


}
