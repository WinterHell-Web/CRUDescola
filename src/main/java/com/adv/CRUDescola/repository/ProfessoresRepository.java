package com.adv.CRUDescola.repository;

import com.adv.CRUDescola.model.ProfessoresModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessoresRepository extends JpaRepository<ProfessoresModel, Integer>
{
    // Procura aluno por usuario_id
    @Query(value = "SELECT * FROM professores WHERE usuario_id = ?", nativeQuery = true)
    public ProfessoresModel findByUsuario(Integer id);
}
