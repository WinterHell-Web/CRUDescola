package com.adv.CRUDescola.controller.admin;

import javax.validation.Valid;

import com.adv.CRUDescola.model.AlunosModel;
import com.adv.CRUDescola.repository.AlunosRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;
import com.adv.CRUDescola.service.AlunosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/alunos")
public class AlunosController 
{
    @Autowired
    private AlunosRepository alunos;

    @Autowired
    private UsuariosRepository usuarios;

    @Autowired
    private AlunosService alunosService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemAlunos(AlunosModel aluno)
    {
        ModelAndView mv = new ModelAndView("admin/alunos/listagemAlunos");

        mv.addObject("alunos", alunos.findAll());
        mv.addObject("usuarios",usuarios.findNotLinkedUser("ROLE_ALUNO"));

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroAluno(AlunosModel aluno)
    {
        ModelAndView mv = new ModelAndView("admin/alunos/cadastroAlunos");

        mv.addObject("usuarios", usuarios.findNotLinkedUser("ROLE_ALUNO"));

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarAluno(@Valid AlunosModel aluno, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroAluno(aluno);
        }

        String[] mensagem = alunosService.cadastrar(aluno);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/alunos/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarAluno(@Valid AlunosModel aluno, RedirectAttributes attributes)
    {
        String[] mensagem = alunosService.atualizar(aluno);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/alunos");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarAluno(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        String[] mensagem = alunosService.excluir(id);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/alunos");
    }
}
