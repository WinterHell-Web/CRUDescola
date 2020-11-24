package com.adv.CRUDescola.controller.professores;

import java.security.Principal;

import javax.validation.Valid;

import com.adv.CRUDescola.model.MatriculasModel;
import com.adv.CRUDescola.model.ProfessoresModel;
import com.adv.CRUDescola.model.UsuariosModel;
import com.adv.CRUDescola.repository.ProfessoresRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;
import com.adv.CRUDescola.service.MatriculasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/professor")
public class ProfessorController 
{
    @Autowired
    private ProfessoresRepository professores;

    @Autowired
    private UsuariosRepository usuarios;

    @Autowired
    private MatriculasService matriculasService;

    // Controle de dados cadastrais
    @RequestMapping("/dadosCad")
    public ModelAndView listagemDadosCad (ProfessoresModel professor, UsuariosModel usuario, Principal principal)
    {
        ModelAndView mv = new ModelAndView("professor/dadosCadastrais");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("professor", professores.findByUsuario(usu.getId()));
        mv.addObject("usuario", usu);

        return mv;
    }
    
    // Controle de listagem de matérias
    @RequestMapping("/materias")
    public ModelAndView listagemMaterias(ProfessoresModel professor, Principal principal)
    {
        ModelAndView mv = new ModelAndView("professor/listagemMaterias");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("professores", professores.findByUsuario(usu.getId()));

        return mv;
    }

    // Controle de atribuição de notas
    @RequestMapping("/cadNotas")
    public ModelAndView cadastroNotas(ProfessoresModel professor, MatriculasModel matricula, Principal principal)
    {
        ModelAndView mv = new ModelAndView("professor/cadastroNotas");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("professores", professores.findByUsuario(usu.getId()));

        return mv;
    }
    @PostMapping("/cadNotas")
    public ModelAndView cadastrarProfessores(@Valid MatriculasModel matricula, RedirectAttributes attributes)
    {
        String[] mensagem = matriculasService.atualizarNotaFalta(matricula);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/professor/cadNotas");
    }
}
