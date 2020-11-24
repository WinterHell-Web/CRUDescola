package com.adv.CRUDescola.controller.admin;

import javax.validation.Valid;

import com.adv.CRUDescola.model.MateriasModel;
import com.adv.CRUDescola.repository.CursosRepository;
import com.adv.CRUDescola.repository.MateriasRepository;
import com.adv.CRUDescola.repository.ProfessoresRepository;
import com.adv.CRUDescola.service.MateriasService;

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
@RequestMapping("/admin/materias")
public class MateriasController 
{
    @Autowired
    private MateriasRepository materias;

    @Autowired
    private CursosRepository cursos;

    @Autowired
    private ProfessoresRepository professores;

    @Autowired
    private MateriasService materiasService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemMaterias(MateriasModel materia)
    {
        ModelAndView mv = new ModelAndView("/admin/materias/listagemMaterias");

        mv.addObject("materias", materias.findAll());
        mv.addObject("cursos", cursos.findAll(Sort.by("nome").ascending()));
        mv.addObject("professores", professores.findAll(Sort.by("nome").ascending()));

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroMateria(MateriasModel materia)
    {
        ModelAndView mv = new ModelAndView("/admin/materias/cadastroMaterias");

        mv.addObject("cursos", cursos.findAll(Sort.by("nome").ascending()));
        mv.addObject("professores", professores.findAll(Sort.by("nome").ascending()));

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarMateria(@Valid MateriasModel materia, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroMateria(materia);
        }

        String[] mensagem = materiasService.cadastrar(materia);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/materias/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarMateria(@Valid MateriasModel materia, RedirectAttributes attributes)
    {
        String[] mensagem = materiasService.atualizar(materia);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/materias");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarMateria(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        String[] mensagem = materiasService.excluir(id);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/materias");
    }
}
