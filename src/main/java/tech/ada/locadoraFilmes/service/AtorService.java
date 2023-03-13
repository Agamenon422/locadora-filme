package tech.ada.locadoraFilmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.locadoraFilmes.dao.AtorDAO;
import tech.ada.locadoraFilmes.model.Ator;

import java.util.List;

@Service
public class AtorService {
    @Autowired
    private AtorDAO atorDAO;

    public List<Ator> criar(Ator ator){
        try {
            atorDAO.adicionar(ator);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar um ator!");
        }
        return atorDAO.buscarFull();
    }
/////////////////////////////////////////////////////////////////////////////////////////
    public List<Ator> buscar(){return atorDAO.buscarFull();}

    public Ator buscarPorId(Integer id){
        try {
            return atorDAO.buscarPorId(id);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o ator!");
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////

    public void atualizar(Ator ator){
        try {
            atorDAO.atualizar(ator);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao atuzalizar o ator!");
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////

    public void remover(Integer id){
        try{
            atorDAO.remover(id);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao remover um ator!");
        }
    }

}
