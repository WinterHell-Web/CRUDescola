package com.adv.CRUDescola.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MATRICULAS")
public class MatriculasModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula", insertable = false, updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "materia_id", referencedColumnName = "id_materia")
    private MateriasModel materia;

    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id_aluno")
    private AlunosModel aluno;

    @NotNull(message = "Ano é obrigatório")
    @Column(name = "ano_matricula")
    private Integer ano;

    @NotNull(message = "Semestre é obrigatório")
    @Column(name = "semestre_matricula")
    private Integer semestre;

    @Column(name = "nota_1_matricula", nullable = true)
    private Integer nota1;

    @Column(name = "nota_2_matricula", nullable = true)
    private Integer nota2;

    @Column(name = "nota_final_matricula", nullable = true)
    private double notaFinal;

    @Column(name = "faltas_matricula", nullable = true)
    private Integer faltas;

    @ManyToOne
    @JoinColumn(name = "situacao_id", referencedColumnName = "id_situacao")
    private SituacoesModel situacao;

    public MatriculasModel()
    {
        super();

        this.id = 0;
        this.ano = 0;
        this.semestre = 0;
        this.nota1 = 0;
        this.nota2 = 0;
        this.notaFinal = 0.0;
        this.faltas = 0;
    }

    public MatriculasModel(Integer id, Integer ano, Integer semestre, Integer nota1, Integer nota2, double notaFinal, Integer faltas)
    {
        super( );

        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaFinal = notaFinal;
        this.faltas = faltas;
    }

    public Integer getId() 
    {
        return this.id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public MateriasModel getMateria() 
    {
        return this.materia;
    }

    public void setMateria(MateriasModel materia) 
    {
        this.materia = materia;
    }

    public AlunosModel getAluno() 
    {
        return this.aluno;
    }

    public void setAluno(AlunosModel aluno) 
    {
        this.aluno = aluno;
    }

    public Integer getAno() 
    {
        return this.ano;
    }

    public void setAno(Integer ano) 
    {
        this.ano = ano;
    }

    public Integer getSemestre() 
    {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) 
    {
        this.semestre = semestre;
    }

    public Integer getNota1() 
    {
        return this.nota1;
    }

    public void setNota1(Integer nota1) 
    {
        this.nota1 = nota1;
    }

    public Integer getNota2() 
    {
        return this.nota2;
    }

    public void setNota2(Integer nota2) 
    {
        this.nota2 = nota2;
    } 

    public double getNotaFinal() 
    {
        return this.notaFinal;
    }

    public void setNotaFinal(double notaFinal) 
    {
        this.notaFinal = notaFinal;
    }

    public Integer getFaltas() 
    {
        return this.faltas;
    }

    public void setFaltas(Integer faltas) 
    {
        this.faltas = faltas;
    }

    public SituacoesModel getSituacao() 
    {
        return this.situacao;
    }

    public void setSituacao(SituacoesModel situacao) 
    {
        this.situacao = situacao;
    } 

    public double getCalcNotaFinal()
    {
        double response;

        response = (this.nota1 + this.nota2) / 2.0;

        return response;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
        {
            return true;
        }
            
        if (!(o instanceof MatriculasModel)) 
        {
            return false;
        }

        MatriculasModel matricula = (MatriculasModel) o;
        return Objects.equals(materia, matricula.materia) && Objects.equals(aluno, matricula.aluno) && Objects.equals(ano, matricula.ano) && Objects.equals(semestre, matricula.semestre) && nota1 == matricula.nota1 && nota2 == matricula.nota2 && notaFinal == matricula.notaFinal && Objects.equals(faltas, matricula.faltas) && Objects.equals(situacao, matricula.situacao);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(materia, aluno, ano, semestre, nota1, nota2, notaFinal, faltas, situacao);
    }
}
