package com.adv.CRUDescola.repository;

import com.adv.CRUDescola.model.MateriasModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MateriasRepository extends JpaRepository<MateriasModel, Integer>
{
    @Query(value = "SELECT COUNT(professor_id) FROM materias WHERE professor_id = ?", nativeQuery = true)
    public int countProfMat (Integer id);

    @Query(value = "SELECT * FROM materias WHERE id_materia = ?", nativeQuery = true)
    public MateriasModel findOneById(Integer id);
}
