package tech.ada.locadoraFilmes.dao;

import org.springframework.stereotype.Component;
import tech.ada.locadoraFilmes.model.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AtorDAO {
    //Em cada DAO, devemos criar uma respectiva lista e seu CRUD;
    private static List<Ator> atores = new ArrayList<>();
    private static int proximoId = 1;

    //CRIA ATOR
    public void adicionar(Ator ator){
        ator.setId(proximoId++);
        atores.add(ator);

    }

    //ATUALIZA ATOR
    public void atualizar(Ator ator){
        for (int i = 0; i<atores.size(); i++){
            Ator atorFor = atores.get(i);
            if (Objects.equals(atorFor.getId(), ator.getId())){
                atores.set(i, ator);
                break;
            }
        }
    }

    //REMOVE ATORES;
    public void remover(Integer id) {
        atores.removeIf(a-> Objects.equals(a.getId(), id));
    }

    //PESQUISA ATOR;
    public  Ator buscarPorId(Integer id){
        return atores
                .stream()
                .filter(a-> Objects.equals(a.getId(), id))
                .findFirst().get();
    }

    //BUSCA FULL;
    public List<Ator>buscarFull() {
        return atores;
    }


}
