package com.adv.CRUDescola.controller;

import com.adv.CRUDescola.repository.Cursos;
import com.adv.CRUDescola.repository.Materias;
import com.adv.CRUDescola.repository.Professores;
import com.adv.CRUDescola.repository.Alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController 
{
    @Autowired
    private Cursos cursos;

    @Autowired
    private Materias materias;

    @Autowired
    private Professores professores;

    @Autowired
    private Alunos alunos;

    @RequestMapping()
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("/index");

        mv.addObject("cursos", cursos.count());
        mv.addObject("materias", materias.count());
        mv.addObject("professores", professores.count());
        mv.addObject("alunos", alunos.count());

        return mv;
    }

    @RequestMapping("/teste")
    public String teste()
    {
        return "/teste";
    }
}
