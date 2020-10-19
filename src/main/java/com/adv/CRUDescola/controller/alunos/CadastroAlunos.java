package com.adv.CRUDescola.controller.alunos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroAlunos
{
    @RequestMapping("/alunos/cadastro")
    public String cadastroAlunos()
    {
        return "/alunos/cadastroAlunos";
    }
}
