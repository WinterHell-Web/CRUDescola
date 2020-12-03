package com.adv.CRUDescola.controller.admin;

import javax.validation.Valid;

import com.adv.CRUDescola.model.CursosModel;
import com.adv.CRUDescola.repository.CursosRepository;
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
@RequestMapping("/admin/cursos")
public class CursosController 
{
    @Autowired
    private CursosRepository cursos;

    @Autowired
    private CursosService cursosService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemCursos(CursosModel curso)
    {
        ModelAndView mv = new ModelAndView("/admin/cursos/listagemCursos");

        mv.addObject("cursos", cursos.findAll());

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroCurso(CursosModel curso)
    {
        return new ModelAndView("/admin/cursos/cadastroCursos");
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarCurso(@Valid CursosModel curso, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroCurso(curso);
        }

        String[] mensagem = cursosService.cadastrar(curso);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/cursos/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarCurso(@Valid CursosModel curso, RedirectAttributes attributes)
    {
        String[] mensagem = cursosService.atualizar(curso);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/cursos");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarCurso(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        String[] mensagem = cursosService.excluir(id);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/cursos");
    }
}