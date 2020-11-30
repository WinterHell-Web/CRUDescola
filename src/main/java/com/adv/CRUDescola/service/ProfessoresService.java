package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.ProfessoresModel;
import com.adv.CRUDescola.repository.ProfessoresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProfessoresService 
{
    @Autowired
    private ProfessoresRepository professores;

    public String[] cadastrar(ProfessoresModel professor)
    {
        String[] response = new String[2];

        String msg1 = "cadastroSuccess";
        String msg2 = "cadastroError";

        try 
        {
            professores.save(professor);

            response[0] = msg1;
            response[1] = "Professor cadastrado com sucesso!";
        }
        catch (DataIntegrityViolationException e)
        {
            response[0] = msg2;
            response[1] = "Professor já cadastrado";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao cadastrar o professor";
        }

        return response;
    }

    public String[] atualizar(ProfessoresModel professor)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";

        try 
        {
            professores.save(professor);

            response[0] = msg1;
            response[1] = "Cadastro de professor alterado com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao alterar o professor";
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
            professores.deleteById(id);

            response[0] = msg1;
            response[1] = "Cadastro de professor deletado com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao deletar o professor";
        }
        
        return response;
    }
}
