package com.adv.CRUDescola.controller.professores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroProfessores
{
    @RequestMapping("/professores/cadastro")
    public String cadastroAlunos()
    {
        return "/professores/cadastroProfessores";
    }
}
