package com.adv.CRUDescola.repository;

import java.util.List;

import com.adv.CRUDescola.model.UsuariosModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer>
{
    // Listagem de usuários não ativos
    @Query(value = "SELECT * FROM usuarios WHERE ativo_usuario = 0", nativeQuery = true)
    public List<UsuariosModel> findAllNotAtivo();

    // Procura por nome de usuário
    @Query(value = "SELECT * FROM usuarios WHERE user_usuario = ?", nativeQuery = true)
    public UsuariosModel findByUsername(String username);

    //Procura usuários que não estejam referenciados
    @Query(value = "SELECT id_usuario, user_usuario, password_usuario, regra_usuario, ativo_usuario " +
                    "FROM usuarios t1 " +
                    "LEFT JOIN alunos t2 " +
                    "ON t1.id_usuario = t2.usuario_id " +
                    "LEFT JOIN professores t3 " +
                    "ON t1.id_usuario = t3.usuario_id " +
                    "WHERE t2.usuario_id IS NULL " +
                    "AND t3.usuario_id IS NULL " +
                    "AND t1.regra_usuario = ? " +
                    "AND t1.ativo_usuario = TRUE", nativeQuery = true)
    public List<UsuariosModel> findNotLinkedUser(String regra);
}
