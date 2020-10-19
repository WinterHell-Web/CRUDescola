package com.adv.CRUDescola.controller.professores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListagemProfessores
{
    @RequestMapping("/professores/listagem")
    public String cadastroAlunos()
    {
        return "/professores/listagemProfessores";
    }
}