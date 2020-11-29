package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.AlunosModel;
import com.adv.CRUDescola.model.MateriasModel;
import com.adv.CRUDescola.model.MatriculasModel;
import com.adv.CRUDescola.repository.AlunosRepository;
import com.adv.CRUDescola.repository.MateriasRepository;
import com.adv.CRUDescola.repository.MatriculasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MatriculasService 
{
    @Autowired
    private MatriculasRepository matriculas;

    @Autowired
    private AlunosRepository alunos;

    @Autowired
    private MateriasRepository materias;

    public String[] cadastrar(MatriculasModel matricula)
    {
        String[] response = new String[2];

        String msg1 = "cadastroSuccess";
        String msg2 = "cadastroError";

        AlunosModel aluno = alunos.findOneById(matricula.getAluno().getId());
        MateriasModel materia = materias.findOneById(matricula.getMateria().getId());

        if (!aluno.getListMatricula().isEmpty())
        {
            for (MatriculasModel aux : aluno.getListMatricula())
            {
                if (!aux.getMateria().getCurso().getId().equals(materia.getCurso().getId()))
                {
                    if (aux.getMateria().getCurso().getPeriodo().equals(materia.getCurso().getPeriodo()))
                    {
                        response[0] = msg2;
                        response[1] = "O aluno não pode estar matriculado em dois cursos no mesmo período";

                        return response;
                    }
                }
            }
        }

        try 
        {
            matriculas.save(matricula);

            response[0] = msg1;
            response[1] = "Matricula cadastrada com sucesso!";
        }
        catch (DataIntegrityViolationException e)
        {
            response[0] = msg2;
            response[1] = "Matricula já cadastrada";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao cadastrar a matricula";
        }

        return response;
    }

    public String[] atualizarSituacao(MatriculasModel matricula)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";        

        try 
        {
            matriculas.updateSituacaoById(matricula.getSituacao().getId(), matricula.getId());

            response[0] = msg1;
            response[1] = "Cadastro de matricula alterada com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao alterar a matricula";
        }
        
        return response;
    }

    public String[] atualizarNotaFalta(MatriculasModel matricula)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";

        try 
        {
            matriculas.updateMatriculaById(matricula.getNota1(), matricula.getNota2(), matricula.getCalcNotaFinal(), matricula.getFaltas(), matricula.getId());

            response[0] = msg1;
            response[1] = "Cadastro de matricula alterada com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao alterar a matricula";
        }
        
        return response;
    }

    public String[] excluir(Integer id)
    {
        String[] response = new String[2];

        String msg1 = "deleteSuccess";
        String msg2 = "deleteError";

        try 
        {
            matriculas.deleteById(id);

            response[0] = msg1;
            response[1] = "Cadastro de matricula deletada com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao deletar a matricula";
        }
        
        return response;
    }
}
