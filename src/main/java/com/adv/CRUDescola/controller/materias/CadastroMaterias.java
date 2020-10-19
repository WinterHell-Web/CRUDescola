package com.adv.CRUDescola.controller.materias;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroMaterias
{
    @RequestMapping("/materias/cadastro")
    public String cadastroAlunos()
    {
        return "/materias/cadastroMaterias";
    }
}
