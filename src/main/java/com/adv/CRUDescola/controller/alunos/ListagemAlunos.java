package com.adv.CRUDescola.controller.alunos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListagemAlunos
{
    @RequestMapping("/alunos/listagem")
    public String cadastroAlunos()
    {
        return "/alunos/listagemAlunos";
    }
}