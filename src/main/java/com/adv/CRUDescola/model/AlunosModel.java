package com.adv.CRUDescola.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ALUNOS")
public class AlunosModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno", insertable = false, updatable = false)
    private Integer id;

    @NotEmpty(message = "Nome do aluno é obrigatório")
    @Column(name = "nome_aluno")
    private String nome;

    @NotEmpty(message = "RA do aluno é obrigatório")
    @Column(name = "ra_aluno", unique = true)
    private String ra;

    @NotEmpty(message = "CPF do aluno é obrigatório")
    @Column(name = "cpf_aluno", unique = true)
    private String cpf;

    @Column(name = "nasc_aluno")
    private Date nasc;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private UsuariosModel usuario;

    @OneToMany(mappedBy = "aluno")
    private List<MatriculasModel> listMatricula;

    public AlunosModel()
    {
        super();

        this.id = 0;
        this.nome = "";
        this.ra = "";
        this.cpf = "";
        this.nasc = null;
    }

    public AlunosModel(Integer id, String nome, String ra, String cpf, Date nasc)
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

    public UsuariosModel getUsuario() 
    {
        return this.usuario;
    }

    public void setUsuario(UsuariosModel usuario) 
    {
        this.usuario = usuario;
    }

    public List<MatriculasModel> getListMatricula() 
    {
        return this.listMatricula;
    }

    public void setListMatricula(List<MatriculasModel> listMatricula) 
    {
        this.listMatricula = listMatricula;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof AlunosModel)) 
        {
            return false;
        }

        AlunosModel aluno = (AlunosModel) o;
        return this.id == aluno.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
