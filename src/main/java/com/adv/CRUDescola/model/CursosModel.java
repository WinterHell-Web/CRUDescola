package com.adv.CRUDescola.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "CURSOS")
public class CursosModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", insertable = false, updatable = false)
    private Integer id;

    @NotEmpty(message = "Nome do curso é obrigatório")
    @Column(name = "nome_curso", unique = true)
    private String nome;

    @NotEmpty(message = "Periodo do curso é obrigatório")
    @Column(name = "periodo_curso")
    private String periodo;

    @OneToMany(mappedBy = "curso")
    private List<MateriasModel> listMateria;

    public CursosModel() 
    {
        super();

        this.id = 0;
        this.nome = "";
        this.periodo = "";
    }

    public CursosModel(Integer id, String nome, String periodo) 
    {
        super( );

        this.id = id;
        this.nome = nome;
        this.periodo = periodo;
    }

    public Integer getId() 
    {
        return this.id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getPeriodo() 
    {
        return this.periodo;
    }

    public void setPeriodo(String periodo) 
    {
        this.periodo = periodo;
    }

    public List<MateriasModel> getListMateria() 
    {
        return this.listMateria;
    }

    public void setListMaterias(List<MateriasModel> listMateria) 
    {
        this.listMateria = listMateria;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof CursosModel)) 
        {
            return false;
        }

        CursosModel curso = (CursosModel) o;
        return this.id == curso.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
