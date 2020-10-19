package com.adv.CRUDescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
    @RequestMapping("/index")
    public String cadastroAlunos()
    {
        return "/index";
    }
}
