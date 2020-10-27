package com.adv.CRUDescola.controller;

import javax.validation.Valid;

import com.adv.CRUDescola.model.Materia;
import com.adv.CRUDescola.repository.Cursos;
import com.adv.CRUDescola.repository.Materias;
import com.adv.CRUDescola.service.MateriasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/materias")
public class MateriasController 
{
    @Autowired
    private Materias materias;

    @Autowired
    private Cursos cursos;

    @Autowired
    private MateriasService materiasService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemMaterias(Materia materia, Pageable pageable)
    {
        ModelAndView mv = new ModelAndView("/materias/listagemMaterias");

        mv.addObject("qntPage", (int) Math.ceil((double) materias.count() / (double) pageable.getPageSize()));
        mv.addObject("navPage", contNav(pageable.getPageNumber(), (int) Math.ceil((double) materias.count() / (double) pageable.getPageSize())));
        mv.addObject("currentPage", pageable.getPageNumber());
        mv.addObject("qntItens", materias.count());

        mv.addObject("materias", materias.findAll(pageable));
        mv.addObject("cursos", cursos.findAll());

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroMateria(Materia materia)
    {
        ModelAndView mv = new ModelAndView("/materias/cadastroMaterias");

        mv.addObject("cursos", cursos.findAll());

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarMateria(@Valid Materia materia, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroMateria(materia);
        }

        materiasService.cadastrar(materia);

        attributes.addFlashAttribute("mensagem1", "Materia cadastrada com sucesso!");

        return new ModelAndView("redirect:/materias/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarCurso(@Valid Materia materia, BindingResult result, RedirectAttributes attributes)
    {
        materiasService.atualizar(materia);

        attributes.addFlashAttribute("mensagem2", "Cadastro de materia alterado com sucesso!");

        return new ModelAndView("redirect:/materias");
    }

    // Controle de exclusão
    @GetMapping("/delete/{id}")
    public ModelAndView deletarCurso(@PathVariable("id") Integer id, RedirectAttributes attributes)
    {        
        materiasService.excluir(id);

        attributes.addFlashAttribute("mensagem3", "Cadastro de materia apagado com sucesso!");

        return new ModelAndView("redirect:/materias");
    }

    // Controle de navegação
    public int contNav (int currentPage, int lastPage)
    {
        int countPage;
        
        if (currentPage < 4)
        {
            countPage = 4;
        }
        else if (currentPage > (lastPage - 4))
        {
            countPage = lastPage - 3;
        }
        else
        {
            countPage = currentPage + 1;
        }
        
        return countPage;
    }
}
