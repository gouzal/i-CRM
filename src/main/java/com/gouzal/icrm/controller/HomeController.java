package com.gouzal.icrm.controller;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/aa")
    public String hello(Model model) {
        return "aa";
    }

}
