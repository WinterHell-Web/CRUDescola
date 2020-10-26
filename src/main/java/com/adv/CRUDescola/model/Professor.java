package com.adv.CRUDescola.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "PROFESSOR")
public class Professor 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @NotEmpty(message = "CPF é obrigatório")
    private String cpf;

    @NotEmpty(message = "Formação é obrigatório")
    private String formacao;

    @OneToOne
    private Materia materia;

    public Professor()
    {
        super();

        this.id = 0;
        this.nome = "";
        this.cpf = "";
    }

    public Professor (Integer id, String nome, String cpf, String formacao)
    {
        super( );

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.formacao = formacao;
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

    public String getCpf() 
    {
        return this.cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public String getFormacao() 
    {
        return this.formacao;
    }

    public void setFormacao(String formacao) 
    {
        this.formacao = formacao;
    }

    public Materia getMateria() 
    {
        return this.materia;
    }

    public void setMateria(Materia materia) 
    {
        this.materia = materia;
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

        Professor professor = (Professor) o;
        return this.id == professor.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
