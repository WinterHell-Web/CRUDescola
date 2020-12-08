package com.adv.CRUDescola.controller.admin;

import javax.validation.Valid;

import com.adv.CRUDescola.model.UsuariosModel;
import com.adv.CRUDescola.repository.UsuariosRepository;
import com.adv.CRUDescola.service.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuariosController 
{
    @Autowired
    private UsuariosRepository usuarios;

    @Autowired
    private UsuariosService usuariosService;

    // Controle principal
    @RequestMapping()
    public ModelAndView listagemUsuarios(UsuariosModel usuario)
    {
        ModelAndView mv = new ModelAndView("/admin/usuarios/listagemUsuarios");

        mv.addObject("usuarios", usuarios.findAll());

        return mv;
    }

    // Controle de cadastro
    @RequestMapping("/cadastro")
    public ModelAndView cadastroUsuarios(UsuariosModel usuario)
    {
        ModelAndView mv = new ModelAndView("/admin/usuarios/cadastroUsuarios");

        mv.addObject("lol", "");

        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView cadastrarUsuarios(@Valid UsuariosModel usuario, BindingResult result, RedirectAttributes attributes)
    {
        String msgS = "cadastroSuccess";
        String msgE = "cadastroError";

        if (result.hasErrors())
        {
            return cadastroUsuarios(usuario);
        }

        try
        {
            usuariosService.cadastrar(usuario);
            attributes.addFlashAttribute(msgS, "Usuário cadastrado com sucesso!");
        }
        catch (DataIntegrityViolationException e)
        {
            attributes.addFlashAttribute(msgE, "Usuário já cadastrado");
        }
        catch (Exception e)
        {
            attributes.addFlashAttribute(msgE, "Erro ao cadastrar o usuário");
        }

        return new ModelAndView("redirect:/admin/usuarios/cadastro");
    }

    // Controle de edição
    @PostMapping("/update")
    public ModelAndView editarUsuario(@Valid UsuariosModel usuario, BindingResult result, RedirectAttributes attributes)
    {
        String[] mensagem = usuariosService.atualizar(usuario);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/usuarios");
    }

    // Controle de exclusão
    @PostMapping("/delete")
    public ModelAndView deletarUsuario(@RequestParam(name = "id") Integer id, RedirectAttributes attributes)
    {        
        String[] mensagem = usuariosService.excluir(id);

        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/admin/usuarios");
    }
}
