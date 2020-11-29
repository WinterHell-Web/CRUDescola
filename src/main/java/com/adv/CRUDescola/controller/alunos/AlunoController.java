package com.adv.CRUDescola.controller.alunos;

import java.io.ByteArrayInputStream;
import java.security.Principal;

import javax.validation.Valid;

import com.adv.CRUDescola.model.AlunosModel;
import com.adv.CRUDescola.model.UsuariosModel;
import com.adv.CRUDescola.repository.AlunosRepository;
import com.adv.CRUDescola.repository.UsuariosRepository;
import com.adv.CRUDescola.service.AlunosService;
import com.adv.CRUDescola.service.UsuariosService;
import com.adv.CRUDescola.util.PdfGeneratorReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aluno")
public class AlunoController 
{
    @Autowired
    private AlunosRepository alunos;

    @Autowired
    private UsuariosRepository usuarios;

    @Autowired
    private AlunosService alunosService;

    @Autowired
    private UsuariosService usuariosService;

    // Controle de dados cadastrais
    @RequestMapping("/dadosCad")
    public ModelAndView listagemDadosCad(AlunosModel aluno, UsuariosModel usuario, Principal principal)
    {
        ModelAndView mv = new ModelAndView("aluno/dadosCadastrais");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("aluno", alunos.findByUsuario(usu.getId()));

        return mv;
    }
    @PostMapping("/dadosCad/update/cad")
    public ModelAndView alteracaoDadosCad(@Valid AlunosModel aluno, RedirectAttributes attributes)
    {
        String[] mensagem = alunosService.atualizar(aluno);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/aluno/dadosCad");
    }
    @PostMapping("/dadosCad/update/pass")
    public ModelAndView alteracaoDadosCad(UsuariosModel usuario, RedirectAttributes attributes)
    {
        String[] mensagem = usuariosService.atualizarPass(usuario);
  
        attributes.addFlashAttribute(mensagem[0], mensagem[1]);

        return new ModelAndView("redirect:/aluno/dadosCad");
    }
    
    // Controle de listagemd de matriculas
    @RequestMapping("/matriculas")
    public ModelAndView cadastroAluno(AlunosModel aluno, Principal principal)
    {
        ModelAndView mv = new ModelAndView("aluno/listagemHistorico");

        UsuariosModel usu = usuarios.findByUsername(principal.getName());

        mv.addObject("alunos", alunos.findByUsuario(usu.getId()));

        return mv;
    }

    // Controle de geração de PDF
    @RequestMapping(value = "/pdfaluno", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> alunosReport(Principal principal) 
    {
        UsuariosModel usu = usuarios.findByUsername(principal.getName());
        AlunosModel aluno = alunos.findByUsuario(usu.getId());

        ByteArrayInputStream bis = PdfGeneratorReport.alunosReport(aluno);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Notas - " + aluno.getNome() + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
