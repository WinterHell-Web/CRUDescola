package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.AlunosModel;
import com.adv.CRUDescola.repository.AlunosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class AlunosService
{
    @Autowired
    private AlunosRepository alunos;

    public String[] cadastrar(AlunosModel aluno)
    {
        String[] response = new String[2];

        String msg1 = "cadastroSuccess";
        String msg2 = "cadastroError";

        if (aluno.getUsuario().getId().equals(0))
        {
            aluno.setUsuario(null);
        }

        try 
        {
            alunos.save(aluno);

            response[0] = msg1;
            response[1] = "Aluno cadastrado com sucesso!";
        }
        catch (DataIntegrityViolationException e)
        {
            response[0] = msg2;
            response[1] = "Aluno já cadastrado";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao cadastrar o aluno";
        }

        return response;
    }

    public String[] atualizar(AlunosModel aluno)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";

        if (aluno.getUsuario().getId().equals(0))
        {
            aluno.setUsuario(null);
        }

        try 
        {
            alunos.save(aluno);

            response[0] = msg1;
            response[1] = "Cadastro de aluno alterado com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao alterar o aluno";
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
            alunos.deleteById(id);

            response[0] = msg1;
            response[1] = "Cadastro de aluno deletado com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao deletar o aluno";
        }
        
        return response;
    }
}
