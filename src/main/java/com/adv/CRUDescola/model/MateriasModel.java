package com.adv.CRUDescola.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "MATERIAS")
public class MateriasModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia", insertable = false, updatable = false)
    private Integer id;

    @NotEmpty(message = "Nome é obrigatório")
    @Column(name = "nome_materia")
    private String nome;

    @NotNull(message = "Semetre é obrigatório")
    @Column(name = "semestre_materia")
    private Integer semestre;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id_curso", nullable = false)
    private CursosModel curso;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id_professor")
    private ProfessoresModel professor;

    @OneToMany(mappedBy = "materia")
    private List<MatriculasModel> listMatricula;

    public MateriasModel()
    {
        super();

        this.id = 0;
        this.nome = "";
        this.semestre = 0;
    }

    public MateriasModel(Integer id, String nome, Integer semestre)
    {
        super( );

        this.id = id;
        this.nome = nome;
        this.semestre = semestre;
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

    public Integer getSemestre() 
    {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) 
    {
        this.semestre = semestre;
    }

    public CursosModel getCurso() 
    {
        return this.curso;
    }

    public void setCurso(CursosModel curso) 
    {
        this.curso = curso;
    }

    public ProfessoresModel getProfessor() 
    {
        return this.professor;
    }

    public void setProfessor(ProfessoresModel professor) 
    {
        this.professor = professor;
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

        if (!(o instanceof MateriasModel)) 
        {
            return false;
        }

        MateriasModel materia = (MateriasModel) o;
        return this.id == materia.id;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }
}
