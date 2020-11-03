package com.adv.CRUDescola.controller;

import javax.validation.Valid;

import com.adv.CRUDescola.model.Professor;
import com.adv.CRUDescola.repository.Materias;
import com.adv.CRUDescola.repository.Professores;
import com.adv.CRUDescola.service.ProfessoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/professores")
public class ProfessoresController 
{
    @Autowired
    private Professores professores;

    @Autowired
    private Materias materias;

    @Autowired
    private ProfessoresService professoresService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemProfessores(Professor professor)
    {
        ModelAndView mv = new ModelAndView("/professores/listagemProfessores");

        mv.addObject("professores", professores.findAll());
        mv.addObject("materias", materias.findAll(Sort.by("nome").ascending()));

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroMateria(Professor professor)
    {
        ModelAndView mv = new ModelAndView("/professores/cadastroProfessores");

        mv.addObject("materias", materias.findAll(Sort.by("nome").ascending()));

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarMateria(@Valid Professor professor, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroMateria(professor);
        }

        professoresService.cadastrar(professor);

        attributes.addFlashAttribute("mensagem1", "Professor cadastrado com sucesso!");

        return new ModelAndView("redirect:/professores/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarCurso(@Valid Professor professor, BindingResult result, RedirectAttributes attributes)
    {
        professoresService.atualizar(professor);

        attributes.addFlashAttribute("mensagem2", "Cadastro de professor alterado com sucesso!");

        return new ModelAndView("redirect:/professores");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarCurso(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        professoresService.excluir(id);

        attributes.addFlashAttribute("mensagem3", "Cadastro de professor apagado com sucesso!");

        return new ModelAndView("redirect:/professores");
    }
}
