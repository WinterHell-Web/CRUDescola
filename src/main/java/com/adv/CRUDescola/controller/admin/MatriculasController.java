package com.adv.CRUDescola.controller.admin;

import javax.validation.Valid;

import com.adv.CRUDescola.model.MatriculasModel;
import com.adv.CRUDescola.repository.AlunosRepository;
import com.adv.CRUDescola.repository.CursosRepository;
import com.adv.CRUDescola.repository.SituacoesRepository;
import com.adv.CRUDescola.service.MatriculasService;

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
@RequestMapping("/admin/matriculas")
public class MatriculasController 
{
    @Autowired
    private AlunosRepository alunos;

    @Autowired
    private CursosRepository cursos;

    @Autowired
    private SituacoesRepository situacoes;

    @Autowired
    private MatriculasService matriculasService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemMatriculas(MatriculasModel matricula)
    {
        ModelAndView mv = new ModelAndView("/admin/matriculas/listagemMatriculas");

        mv.addObject("alunos", alunos.findAll());

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroMatricula(MatriculasModel matricula)
    {
        ModelAndView mv = new ModelAndView("/admin/matriculas/cadastroMatriculas");

        mv.addObject("cursos", cursos.findAll(Sort.by("nome").ascending()));
        mv.addObject("alunos", alunos.findAll(Sort.by("nome").ascending()));
        mv.addObject("situacoes", situacoes.findAll(Sort.by("descricao").ascending()));

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarMatricula(@Valid MatriculasModel matricula, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroMatricula(matricula);
        }

        String[] mensagem = matriculasService.cadastrar(matricula);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/matriculas/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarMateria(@Valid MatriculasModel matricula, BindingResult result, RedirectAttributes attributes)
    {
        String[] mensagem = matriculasService.atualizar(matricula);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/matriculas");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarMateria(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        String[] mensagem = matriculasService.excluir(id);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/matriculas");
    }
}
