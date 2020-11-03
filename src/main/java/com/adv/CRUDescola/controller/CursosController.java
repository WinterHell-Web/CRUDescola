package com.adv.CRUDescola.controller;

import javax.validation.Valid;

import com.adv.CRUDescola.model.Curso;
import com.adv.CRUDescola.repository.Cursos;
import com.adv.CRUDescola.service.CursosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cursos")
public class CursosController 
{
    @Autowired
    private Cursos cursos;

    @Autowired
    private CursosService cursosService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemCursos(Curso curso)
    {
        ModelAndView mv = new ModelAndView("/cursos/listagemCursos");

        mv.addObject("cursos", cursos.findAll());

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroCurso(Curso curso)
    {
        return new ModelAndView("/cursos/cadastroCursos");
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarCurso(@Valid Curso curso, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroCurso(curso);
        }

        cursosService.cadastrar(curso);

        attributes.addFlashAttribute("mensagem1", "Curso cadastrado com sucesso!");

        return new ModelAndView("redirect:/cursos/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarCurso(@Valid Curso curso, BindingResult result, RedirectAttributes attributes)
    {
        cursosService.atualizar(curso);

        attributes.addFlashAttribute("mensagem2", "Cadastro de curso alterado com sucesso!");

        return new ModelAndView("redirect:/cursos");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarCurso(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        cursosService.excluir(id);

        attributes.addFlashAttribute("mensagem3", "Cadastro de curso apagado com sucesso!");

        return new ModelAndView("redirect:/cursos");
    }
}