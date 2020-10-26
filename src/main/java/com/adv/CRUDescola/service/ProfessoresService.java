package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.Professor;
import com.adv.CRUDescola.repository.Professores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessoresService 
{
    @Autowired
    private Professores professores;

    public void cadastrar(Professor professor)
    {
        // Regras de negócio...

        this.professores.save(professor);
    }

    public void atualizar(Professor professor)
    {
        // Regras de negócio...

        this.professores.save(professor);
    }

    public void excluir(Integer id)
    {
        // Regras de negócio...

        this.professores.deleteById(id);
    }
}
