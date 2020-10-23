package com.org.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model){
        model.addAttribute("msg","<h1>helloworld</h1>");
        model.addAttribute("users", Arrays.asList("lin","lin12"));

        return "test";
    }
}
