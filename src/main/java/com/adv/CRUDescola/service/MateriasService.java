package com.adv.CRUDescola.service;

import com.adv.CRUDescola.model.MateriasModel;
import com.adv.CRUDescola.repository.MateriasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MateriasService 
{
    @Autowired
    private MateriasRepository materias;

    public String[] cadastrar(MateriasModel materia)
    {
        String[] response = new String[2];

        String msg1 = "cadastroSuccess";
        String msg2 = "cadastroError";

        if (!verificaProfessor(materia))
        {
            response[0] = msg2;
            response[1] = "Não é possível cadastrar o mesmo professor em mais de 3 matérias";

            return response;
        }

        try 
        {
            materias.save(materia);

            response[0] = msg1;
            response[1] = "Matéria cadastrada com sucesso!";
        }
        catch (DataIntegrityViolationException e)
        {
            response[0] = msg2;
            response[1] = "Matéria já cadastrada";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao cadastrar a matéria";
        }

        return response;
    }

    public String[] atualizar(MateriasModel materia)
    {
        String[] response = new String[2];

        String msg1 = "alteracaoSuccess";
        String msg2 = "alteracaoError";

        if (!verificaProfessor(materia))
        {
            response[0] = msg2;
            response[1] = "Não é possível cadastrar o mesmo professor em mais de 3 matérias";

            return response;
        }

        try 
        {
            materias.save(materia);

            response[0] = msg1;
            response[1] = "Cadastro de matéria alterada com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao alterar a matéria";
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
            materias.deleteById(id);

            response[0] = msg1;
            response[1] = "Cadastro de matéria deletada com sucesso!";
        }
        catch (Exception e)
        {
            response[0] = msg2;
            response[1] = "Erro ao deletar a matéria";
        }
        
        return response;
    }

    private boolean verificaProfessor(MateriasModel materia)
    {
        if (materia.getProfessor() != null)
        {
            int matQnt = materias.countProfMat(materia.getProfessor().getId());

            if (matQnt >= 3)
            {
                return false;       
            }
        }

        return true;
    }
}
