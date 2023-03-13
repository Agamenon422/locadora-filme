package tech.ada.locadoraFilmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.ada.locadoraFilmes.model.Filme;
import tech.ada.locadoraFilmes.model.Noticia;
import tech.ada.locadoraFilmes.service.FilmeService;
import tech.ada.locadoraFilmes.service.NoticiaService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class homeController {
    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private FilmeService filmeService;

    @GetMapping()//endpoint
    public String homeFilme(Model model) {
        List<Filme> filmes = filmeService.buscarTodos();
        List<Noticia> noticias = noticiaService.buscarTodas();
        model.addAttribute("filmes", filmes);
        model.addAttribute("noticias", noticias);
        return "home";
    }

    @PostMapping("/home/filme")
    public String homeFilme(Filme filme) {
        filmeService.criar(filme);
        return "redirect:/home/filme_listar";
    }
    ///////////////////////////////////////////////////////////////////////////

    @GetMapping("/home/noticia")
    public String home(Model model) {
        List<Noticia> noticias = noticiaService.buscarTodas();
        model.addAttribute("noticia", noticias);
        return "home";
    }
    @PostMapping("/home/noticia")
    public String home(Noticia noticia) {
        noticiaService.atualizar(noticia);
        return "redirect:/noticia_listar";
    }
    @GetMapping("/like/{id}")
    public String like(@PathVariable Integer id) {
        filmeService.like(id);
        return "redirect:/home";
    }

    @GetMapping("/dislike/{id}")
    public String dislike(@PathVariable Integer id) {
        filmeService.dislike(id);
        return "redirect:/home";
    }
}