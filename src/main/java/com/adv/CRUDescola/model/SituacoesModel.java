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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "SITUACOES")
public class SituacoesModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_situacao", insertable = false, updatable = false)
    private Integer id;

    @NotEmpty(message = "Descrição é obrigatória")
    @Column(name = "descricao_situacao", unique = true)
    private String descricao;

    @OneToMany(mappedBy = "situacao")
    private List<MatriculasModel> listMatriculas;

    public SituacoesModel()
    {
        super();

        this.id = 0;
        this.descricao = "";
    }

    public SituacoesModel(Integer id, String descricao)
    {
        super( );

        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() 
    {
        return this.id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getDescricao() 
    {
        return this.descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public List<MatriculasModel> getListMatriculas() 
    {
        return this.listMatriculas;
    }

    public void setListMatriculas(List<MatriculasModel> listMatriculas) 
    {
        this.listMatriculas = listMatriculas;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof SituacoesModel))
        {
            return false;
        }

        SituacoesModel situacao = (SituacoesModel) o;
        return this.id == situacao.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
