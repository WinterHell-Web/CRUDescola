package com.adv.CRUDescola.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "MATERIA")
public class Materia 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @ManyToOne
    private Curso curso;

    public Materia()
    {
        super();

        this.id = 0;
        this.nome = "";        
    }

    public Materia (Integer id, String nome)
    {
        super( );

        this.id = id;
        this.nome = nome;
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

    public Curso getCurso() 
    {
        return this.curso;
    }

    public void setCurso(Curso curso) 
    {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass()) 
        {
            return false;
        }

        Materia materia = (Materia) o;
        return this.id == materia.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
