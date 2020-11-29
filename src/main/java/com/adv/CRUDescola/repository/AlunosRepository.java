package com.adv.CRUDescola.repository;

import com.adv.CRUDescola.model.AlunosModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunosRepository extends JpaRepository<AlunosModel, Integer>
{
    // Procura aluno por usuario_id
    @Query(value = "SELECT * FROM alunos WHERE usuario_id = ?", nativeQuery = true)
    public AlunosModel findByUsuario(Integer id);

    @Query(value = "SELECT * FROM alunos WHERE id_aluno = ?", nativeQuery = true)
    public AlunosModel findOneById(Integer id);
}
