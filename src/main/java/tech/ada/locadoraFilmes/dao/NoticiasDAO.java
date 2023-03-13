package tech.ada.locadoraFilmes.dao;

import org.springframework.stereotype.Component;
import tech.ada.locadoraFilmes.model.Noticia;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticiasDAO {
    private static List<Noticia> noticias = new ArrayList<>();
    private static int proximoId;

    //CRIA NOTICIA;
    public void adicionarNoticia(Noticia noticia){
        noticia.setId(++proximoId);
        noticias.add(noticia);
    }

    //ATUALIZA NOTICIA;
    public void atualizarNoticia(Noticia noticia){
        for (int i = 0; i < noticias.size(); i++){
            Noticia noticiaFor = noticias.get(i);
            if (noticiaFor.getId()== noticia.getId()){
                noticias.set(i, noticia);
                break;
            }
        }
    }

    //REMOVE NOTICIA;
    public void removerNoticia(int id){
        noticias.removeIf(n -> n.getId() == id);
    }

    //PESQUISA POR ID NOTICIA;
    public Noticia buscarPorIdNoticia(int id){
        return noticias
                .stream()
                .filter(n -> n.getId() == id)
                .findFirst().get();
    }

    //PESQUISA FUL NOTÍCIAS;
    public List<Noticia> buscarTodas(){
        return noticias;
    }
}
