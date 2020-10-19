package com.adv.CRUDescola.controller.cursos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListagemCursos
{
    @RequestMapping("/cursos/listagem")
    public String cadastroAlunos()
    {
        return "/cursos/listagemCursos";
    }
}