package com.adv.CRUDescola.controller.admin;

import javax.validation.Valid;

import com.adv.CRUDescola.model.ProfessoresModel;
import com.adv.CRUDescola.repository.MateriasRepository;
import com.adv.CRUDescola.repository.ProfessoresRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;
import com.adv.CRUDescola.service.ProfessoresService;

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
@RequestMapping("/admin/professores")
public class ProfessoresController 
{
    @Autowired
    private ProfessoresRepository professores;

    @Autowired
    private MateriasRepository materias;

    @Autowired
    private UsuariosRepository usuarios;

    @Autowired
    private ProfessoresService professoresService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemProfessores(ProfessoresModel professor)
    {
        ModelAndView mv = new ModelAndView("/admin/professores/listagemProfessores");

        mv.addObject("professores", professores.findAll());
        mv.addObject("materias", materias.findAll(Sort.by("nome").ascending()));
        mv.addObject("usuarios", usuarios.findNotLinkedUser("ROLE_PROFESSOR"));

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroProfessores(ProfessoresModel professor)
    {
        ModelAndView mv = new ModelAndView("/admin/professores/cadastroProfessores");

        mv.addObject("materias", materias.findAll(Sort.by("nome").ascending()));
        mv.addObject("usuarios", usuarios.findNotLinkedUser("ROLE_PROFESSOR"));

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarProfessores(@Valid ProfessoresModel professor, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            return cadastroProfessores(professor);
        }

        String[] mensagem = professoresService.cadastrar(professor);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/professores/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarProfessor(@Valid ProfessoresModel professor, RedirectAttributes attributes)
    {
        String[] mensagem = professoresService.atualizar(professor);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/professores");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarProfessor(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        String[] mensagem = professoresService.excluir(id);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/professores");
    }
}
