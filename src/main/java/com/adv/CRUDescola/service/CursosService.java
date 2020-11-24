package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.CursosModel;
import com.adv.CRUDescola.repository.CursosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CursosService 
{
    @Autowired
    private CursosRepository cursos;

    public String[] cadastrar(CursosModel curso)
    {
        String[] response = new String[2];

        String msg1 = "cadastroSuccess";
        String msg2 = "cadastroError";

        try 
        {
            cursos.save(curso);

            response[0] = msg1;
            response[1] = "Curso cadastrado com sucesso!";
        }
        catch (DataIntegrityViolationException e)
        {
            response[0] = msg2;
            response[1] = "Curso já cadastrado";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao cadastrar o curso";
        }

        return response;
    }

    public String[] atualizar(CursosModel curso)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";

        try 
        {
            cursos.save(curso);

            response[0] = msg1;
            response[1] = "Cadastro de curso alterado com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao alterar o curso";
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
            cursos.deleteById(id);

            response[0] = msg1;
            response[1] = "Cadastro de curso deletado com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao deletar o curso";
        }
        
        return response;
    }
}
