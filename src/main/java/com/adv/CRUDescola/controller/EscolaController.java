package com.adv.CRUDescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EscolaController 
{
    @RequestMapping("/escola")
    public String cadastroAlunos()
    {
        return "/escola";
    }
}
