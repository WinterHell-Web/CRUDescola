package com.adv.CRUDescola.controller.cursos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroCursos
{
    @RequestMapping("/cursos/cadastro")
    public String cadastroAlunos()
    {
        return "/cursos/cadastroCursos";
    }
}
