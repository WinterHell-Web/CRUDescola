package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.Aluno;
import com.adv.CRUDescola.repository.Alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunosService 
{
    @Autowired
    private Alunos alunos;

    public void cadastrar(Aluno aluno)
    {
        // Regras de negócio...

        this.alunos.save(aluno);
    }

    public void atualizar(Aluno aluno)
    {
        // Regras de negócio...

        this.alunos.save(aluno);
    }

    public void excluir(Integer id)
    {
        // Regras de negócio...

        this.alunos.deleteById(id);
    }
}
