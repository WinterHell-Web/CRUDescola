package com.adv.CRUDescola.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "ALUNO")
public class Aluno 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @NotEmpty(message = "RA é obrigatório")
    private String ra;

    @NotEmpty(message = "CPF é obrigatório")
    private String cpf;

    private Date nasc;

    @ManyToOne
    private Curso curso;

    public Aluno()
    {
        super();

        this.id = 0;
        this.nome = "";
        this.ra = "";
        this.cpf = "";
        this.nasc = null;
    }

    public Aluno(Integer id, String nome, String ra, String cpf, Date nasc)
    {
        super( );

        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.cpf = cpf;
        this.nasc = nasc;
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

    public String getRa() 
    {
        return this.ra;
    }

    public void setRa(String ra) 
    {
        this.ra = ra;
    }

    public String getCpf() 
    {
        return this.cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public Date getNasc() 
    {
        return this.nasc;
    }

    public void setNasc(Date nasc) 
    {
        this.nasc = nasc;
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

        Aluno aluno = (Aluno) o;
        return this.id == aluno.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
