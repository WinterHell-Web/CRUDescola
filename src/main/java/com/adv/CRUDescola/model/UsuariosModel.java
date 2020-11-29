package com.adv.CRUDescola.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "USUARIOS")
public class UsuariosModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", insertable = false, updatable = false)
    private Integer id;

    @NotEmpty(message = "User do usuário é obrigatório")
    @Column(name = "user_usuario", unique = true)
    private String user;

    @NotEmpty(message = "Senha do usuário é obrigatória")
    @Column(name = "password_usuario")
    private String password;

    @NotEmpty(message = "Nível de acesso so usuário é obrigatório")
    @Column(name = "regra_usuario")
    private String regra;

    @Column(name = "ativo_usuario")
    private boolean ativo;

    public UsuariosModel()
    {
        this.id = 0;
        this.user = "";
        this.password = "";
        this.regra = "";
        this.ativo = false;
    }

    public UsuariosModel(Integer id, String user, String password, String regra, boolean ativo)
    {
        this.id = id;
        this.user = user;
        this.password = password;
        this.regra = regra;
        this.ativo = ativo;
    }

    public Integer getId() 
    {
        return this.id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getUser() 
    {
        return this.user;
    }

    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getPassword() 
    {
        return this.password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getRegra() 
    {
        return this.regra;
    }

    public void setRegra(String regra) 
    {
        this.regra = regra;
    }

    public boolean isAtivo() 
    {
        return this.ativo;
    }

    public boolean getAtivo() 
    {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) 
    {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof UsuariosModel)) 
        {
            return false;
        }

        UsuariosModel usuariosModel = (UsuariosModel) o;
        return Objects.equals(id, usuariosModel.id);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
