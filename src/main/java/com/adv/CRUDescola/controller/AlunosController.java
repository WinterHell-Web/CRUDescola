package com.adv.CRUDescola.controller;

import javax.validation.Valid;

import com.adv.CRUDescola.model.Aluno;
import com.adv.CRUDescola.repository.Alunos;
import com.adv.CRUDescola.repository.Cursos;
import com.adv.CRUDescola.service.AlunosService;

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
@RequestMapping("/alunos")
public class AlunosController 
{
    @Autowired
    private Alunos alunos;

    @Autowired
    private Cursos cursos;

    @Autowired
    private AlunosService alunosService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemAlunos(Aluno aluno, Pageable pageable)
    {
        ModelAndView mv = new ModelAndView("/alunos/listagemAlunos");

        mv.addObject("alunos", alunos.findAll(pageable));
        mv.addObject("cursos", cursos.findAll());

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroAluno(Aluno aluno)
    {
        ModelAndView mv = new ModelAndView("/alunos/cadastroAlunos");

        mv.addObject("cursos", cursos.findAll());

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroAluno(aluno);
        }

        alunosService.cadastrar(aluno);

        attributes.addFlashAttribute("mensagem1", "Aluno cadastrado com sucesso!");

        return new ModelAndView("redirect:/alunos/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarCurso(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes)
    {
        alunosService.atualizar(aluno);

        attributes.addFlashAttribute("mensagem2", "Cadastro de aluno alterado com sucesso!");

        return new ModelAndView("redirect:/alunos");
    }

    // Controle de exclusão
    @GetMapping("/delete/{id}")
    public ModelAndView deletarAluno(@PathVariable("id") Integer id, RedirectAttributes attributes)
    {        
        alunosService.excluir(id);

        attributes.addFlashAttribute("mensagem3", "Cadastro de aluno apagado com sucesso!");

        return new ModelAndView("redirect:/alunos");
    }
}
