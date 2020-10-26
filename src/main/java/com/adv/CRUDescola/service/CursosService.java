package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.Curso;
import com.adv.CRUDescola.repository.Cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService 
{
    @Autowired
    private Cursos cursos;

    public void cadastrar(Curso curso)
    {
        // Regras de negócio...

        this.cursos.save(curso);
    }

    public void atualizar(Curso curso)
    {
        // Regras de negócio...

        this.cursos.save(curso);
    }

    public void excluir(Integer id)
    {
        // Regras de negócio...

        this.cursos.deleteById(id);
    }
}
