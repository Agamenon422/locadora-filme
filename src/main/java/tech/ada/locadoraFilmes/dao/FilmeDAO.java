package tech.ada.locadoraFilmes.dao;

import org.springframework.stereotype.Component;
import tech.ada.locadoraFilmes.model.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//BANCO DE DADOS;
@Component
public class FilmeDAO {
    public static List<Filme> filmes = new ArrayList<>();//todos os filmes estão referênciando a classe, e não a instância;

    private static int proximoId = 1;

    //CRIA FILME;
    public void adicionarFilme(Filme filme){
        filme.setId(proximoId++);
        filmes.add(filme);
    }

    //ATUALIZA FILME/
    public void atualizarFilme(Filme filme){
        for (int i = 0; i < filmes.size(); i++){
            Filme filmeEncontrado = filmes.get(i);

            if (filmeEncontrado.getId() == filme.getId()) {
                filmes.set(i, filme);
                break;
            }
        }
    }
    //REMOVE FILME;
    public void removerFilme(int id){//removo atrasvés de uma validação do id;

        filmes.removeIf(filme -> filme.getId() == id);
    }

    //PESQUISA FILME;
    public Filme buscarPorId(int id){
        return filmes
            .stream().filter( filme -> filme.getId() == id)
            .findFirst().orElse(null);
    }

    //BUSCA FLL;
    public List<Filme> buscarTodosFilmes(){
        return filmes;
    }

    public void like(Integer id){
        for (int i = 0; i < filmes.size(); i++){
            Filme filmeLike = filmes.get(i);

            if (filmeLike.getId() == id) {
                filmeLike.setLike(filmeLike.getLike()+1);
                break;
            }
        }
    }
    public void dislike(Integer id){
        for (int i = 0; i < filmes.size(); i++) {
            Filme filmeDislike = filmes.get(i);

           if (filmeDislike.getId() == id) {
                filmeDislike.setDislike(filmeDislike.getDislike()+1);
                break;
            }
        }
    }
}
