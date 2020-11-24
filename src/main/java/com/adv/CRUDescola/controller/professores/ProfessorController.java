package com.adv.CRUDescola.controller.professores;

import java.security.Principal;

import com.adv.CRUDescola.model.ProfessoresModel;
import com.adv.CRUDescola.model.UsuariosModel;
import com.adv.CRUDescola.repository.ProfessoresRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/professor")
public class ProfessorController 
{
    @Autowired
    private ProfessoresRepository professores;

    @Autowired
    private UsuariosRepository usuarios;
    
    // Controle de cadastro
    @RequestMapping("/materias")
    public ModelAndView listagemMaterias(ProfessoresModel professor, Principal principal)
    {
        ModelAndView mv = new ModelAndView("professor/listagemMaterias");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("professores", professores.findByUsuario(usu.getId()));

        return mv;
    }

    @RequestMapping("/cadNotas")
    public ModelAndView cadastroNotas(ProfessoresModel professor, Principal principal)
    {
        ModelAndView mv = new ModelAndView("professor/cadastroNotas");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("professores", professores.findByUsuario(usu.getId()));

        return mv;
    }
}
