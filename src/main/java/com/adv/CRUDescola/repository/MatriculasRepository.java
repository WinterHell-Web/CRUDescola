package com.adv.CRUDescola.repository;

import com.adv.CRUDescola.model.MatriculasModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MatriculasRepository extends JpaRepository<MatriculasModel, Integer>
{
    // Atualiza as notas e faltas da matricula referente
    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE matriculas SET nota_1_matricula = ?1, nota_2_matricula = ?2, nota_final_matricula = ?3, faltas_matricula = ?4 WHERE id_matricula = ?5", nativeQuery = true)
    public void updateMatriculaById(double nota1, double nota2, double notaFinal, Integer faltas, Integer id);
}
