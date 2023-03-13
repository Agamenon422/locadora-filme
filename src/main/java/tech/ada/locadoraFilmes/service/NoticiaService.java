package tech.ada.locadoraFilmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.locadoraFilmes.dao.NoticiasDAO;
import tech.ada.locadoraFilmes.model.Noticia;

import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    private NoticiasDAO noticiasDAO;

    public void criar(Noticia noticia){
        try {
            noticiasDAO.adicionarNoticia(noticia);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao criar notícia!");
        }

    }

    public List<Noticia> buscarTodas() {
        return noticiasDAO.buscarTodas();
    }

    public void atualizar(Noticia noticia){
        try {
            noticiasDAO.atualizarNoticia(noticia);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar notícia!");
        }
    }

    public void remover(Integer id){
        try {
            noticiasDAO.removerNoticia(id);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao remover notícia!");
        }
    }

    public Noticia buscarPorId(Integer id){
        return noticiasDAO.buscarPorIdNoticia(id);
    }
}
