package com.adv.CRUDescola.controller.alunos;

import java.security.Principal;

import com.adv.CRUDescola.model.AlunosModel;
import com.adv.CRUDescola.model.UsuariosModel;
import com.adv.CRUDescola.repository.AlunosRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aluno")
public class AlunoController 
{
    @Autowired
    private AlunosRepository alunos;

    @Autowired
    private UsuariosRepository usuarios;
    
    // Controle de cadastro
    @RequestMapping("/matriculas")
    public ModelAndView cadastroAluno(AlunosModel aluno, Principal principal)
    {
        ModelAndView mv = new ModelAndView("aluno/listagemHistorico");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("alunos", alunos.findByUsuario(usu.getId()));

        return mv;
    }
}
