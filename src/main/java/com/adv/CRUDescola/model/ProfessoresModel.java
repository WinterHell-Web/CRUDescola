package com.adv.CRUDescola.model;

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
import javax.validation.constraints.*;

@Entity
@Table(name = "PROFESSORES")
public class ProfessoresModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor", insertable = false, updatable = false)
    private Integer id;

    @NotEmpty(message = "Nome do professor é obrigatório")
    @Column(name = "nome_professor", unique = true)
    private String nome;

    @NotEmpty(message = "CPF do professor é obrigatório")
    @Column(name = "cpf_professor", unique = true)
    private String cpf;

    @NotEmpty(message = "Formação do professor é obrigatória")
    @Column(name = "formacao_professor", unique = true)
    private String formacao;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private UsuariosModel usuario;

    @OneToMany(mappedBy = "professor")
    private List<MateriasModel> listMateria;

    public ProfessoresModel()
    {
        super();

        this.id = 0;
        this.nome = "";
        this.cpf = "";
        this.formacao = "";
    }

    public ProfessoresModel(Integer id, String nome, String cpf, String formacao)
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

    public List<MateriasModel> getListMateria() 
    {
        return this.listMateria;
    }

    public void setListMateria(List<MateriasModel> listMateria) 
    {
        this.listMateria = listMateria;
    }

    public UsuariosModel getUsuario() 
    {
        return this.usuario;
    }

    public void setUsuario(UsuariosModel usuario) 
    {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof ProfessoresModel)) 
        {
            return false;
        }

        ProfessoresModel professor = (ProfessoresModel) o;
        return this.id == professor.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
