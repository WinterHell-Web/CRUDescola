package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.MatriculasModel;
import com.adv.CRUDescola.repository.MatriculasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MatriculasService 
{
    @Autowired
    private MatriculasRepository matriculas;

    public String[] cadastrar(MatriculasModel matricula)
    {
        String[] response = new String[2];

        String msg1 = "cadastroSuccess";
        String msg2 = "cadastroError";

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

    public String[] atualizar(MatriculasModel matricula)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";

        try 
        {
            matriculas.save(matricula);

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
