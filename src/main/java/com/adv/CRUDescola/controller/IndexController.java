package com.adv.CRUDescola.controller;

import com.adv.CRUDescola.repository.CursosRepository;
import com.adv.CRUDescola.repository.MateriasRepository;
import com.adv.CRUDescola.repository.MatriculasRepository;
import com.adv.CRUDescola.repository.ProfessoresRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import com.adv.CRUDescola.model.UsuariosModel;
import com.adv.CRUDescola.repository.AlunosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/index"})
public class IndexController 
{
    @Autowired
    private CursosRepository cursos;

    @Autowired
    private MateriasRepository materias;

    @Autowired
    private ProfessoresRepository professores;

    @Autowired
    private AlunosRepository alunos;

    @Autowired
    private MatriculasRepository matriculas;

    @Autowired
    private UsuariosRepository usuarios;

    @RequestMapping()
    public ModelAndView index(HttpServletRequest auth, Principal principal)
    {
        ModelAndView mv = null;

        if (auth.isUserInRole("ROLE_ADM"))
        {
            mv = new ModelAndView("/admin/index");

            mv.addObject("cursos", cursos.count());
            mv.addObject("materias", materias.count());
            mv.addObject("professores", professores.count());
            mv.addObject("alunos", alunos.count());
            mv.addObject("matriculas", matriculas.count());
            mv.addObject("usuarios", usuarios.count());
        }
        else if (auth.isUserInRole("ROLE_ALUNO"))
        {
            mv = new ModelAndView("/aluno/index");

            UsuariosModel usu = usuarios.findByUsername(principal.getName());

            mv.addObject("matriculas", alunos.findByUsuario(usu.getId()).getListMatricula().size());
            mv.addObject("aluno", alunos.findByUsuario(usu.getId()));
        }
        else if (auth.isUserInRole("ROLE_PROFESSOR"))
        {
            mv = new ModelAndView("/professor/index");

            UsuariosModel usu = usuarios.findByUsername(principal.getName());

            mv.addObject("materias", professores.findByUsuario(usu.getId()).getListMateria().size());
            mv.addObject("professor", professores.findByUsuario(usu.getId()));
        }

        return mv;
    }

    @RequestMapping("/teste")
    public ModelAndView teste()
    {
        ModelAndView mv = new ModelAndView("/teste");

        mv.addObject("materias", materias.findAll());

        return mv;
    }
}
