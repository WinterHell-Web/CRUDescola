package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.Materia;
import com.adv.CRUDescola.repository.Materias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriasService 
{
    @Autowired
    private Materias materias;

    public void cadastrar(Materia materia)
    {
        // Regras de negócio...

        this.materias.save(materia);
    }

    public void atualizar(Materia materia)
    {
        // Regras de negócio...

        this.materias.save(materia);
    }

    public void excluir(Integer id)
    {
        // Regras de negócio...

        this.materias.deleteById(id);
    }
}
