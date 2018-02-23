package me.abebe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping( path = "/login")
    public String login(){

        return "login";
    }


}
