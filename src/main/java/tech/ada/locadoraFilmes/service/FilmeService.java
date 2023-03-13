package tech.ada.locadoraFilmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.locadoraFilmes.dao.FilmeDAO;
import tech.ada.locadoraFilmes.model.Ator;
import tech.ada.locadoraFilmes.model.Filme;
import tech.ada.locadoraFilmes.model.Noticia;

import java.util.List;

import static tech.ada.locadoraFilmes.dao.FilmeDAO.filmes;

@Service
public class FilmeService {

    @Autowired
    private FilmeDAO filmeDAO;

    public List<Filme> criar(Filme filme ) {

        try {
            filmeDAO.adicionarFilme(filme);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar um filme!");
        }

        return filmeDAO.buscarTodosFilmes();
    }

    public void like(Integer id){
        filmeDAO.like(id);
    }

    public void dislike(Integer id){
        filmeDAO.dislike(id);
    }

    public List<Filme> buscarTodos(){return filmeDAO.buscarTodosFilmes();}



    public Filme buscarPorId(Integer id){
        return filmes.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }
}
