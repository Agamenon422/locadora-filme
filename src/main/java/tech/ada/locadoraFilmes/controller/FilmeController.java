package tech.ada.locadoraFilmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.ada.locadoraFilmes.dao.FilmeDAO;
import tech.ada.locadoraFilmes.model.Filme;
import tech.ada.locadoraFilmes.service.FilmeService;

import java.util.List;

@Controller
@RequestMapping("/filme")//endpoint
public class FilmeController {
    @Autowired
    private FilmeDAO filmeDAO;
    @Autowired
    private FilmeService filmeService;

    @PostMapping("/novo")
    public String adicionar(Filme filme) {
        filmeService.criar(filme);
        return "redirect:/filme";
    }

    /////////////////////////////////////////////////////////////////////////////////
    @GetMapping//representa o 'doGet';
    public String listar(Model model) {
        List<Filme> filmes = filmeDAO.buscarTodosFilmes();
        model.addAttribute("filmes", filmes);
        return "filme_listar";
    }

    ////////////////////////////////////////////////////////////////////////////

    @GetMapping("/editar/{id}")
//@PathVariable-> essa anotação fala que tenho uma variável nela que é da linha 40 ({id});
    public String editar(@PathVariable int id, Model model) {//a função do model é carregar junto com interface;
        Filme filme = filmeService.buscarPorId(id);
        model.addAttribute("filme", filme);
        return "filme_editar";
    }

    @PostMapping("/editar")
    public String editar(Filme filme) {
        filmeDAO.atualizarFilme(filme);
        return "redirect:/filme";
    }

    ////////////////////////////////////////////////////////////////////////////

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        filmeDAO.removerFilme(id);
        return "redirect:/filme";
    }

    ////////////////////////////////////////////////////////////////////////////

    @GetMapping("/novo")//subrota
    public String novoFilme(Model model) {//esse produto vai ser implementando/salvo no momento q eu chamar o POSt dentro daquela tela;
        model.addAttribute("filme", new Filme());
        return "filme_novo";
    }

    ////////////////////////////////////////////////////////////////////////////

    @GetMapping("/like/{id}")
    public String like(@PathVariable Integer id) {
        filmeService.like(id);
        return "redirect:/filme";
    }

    @GetMapping("/dislike/{id}")
    public String dislike(@PathVariable Integer id) {
        filmeService.dislike(id);
        return "redirect:/filme";
    }
}





