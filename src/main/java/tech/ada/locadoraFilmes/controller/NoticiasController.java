package tech.ada.locadoraFilmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.ada.locadoraFilmes.model.Noticia;
import tech.ada.locadoraFilmes.service.NoticiaService;

import java.util.List;

@Controller
@RequestMapping("/noticia")
public class NoticiasController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping//representa o 'doGet';
    public String listar(Model model) {
        List<Noticia> noticias = noticiaService.buscarTodas();
        model.addAttribute("noticia", noticias);
        return "noticia_listar";
    }

    //////////////////////////////////////////////////////////////////

    @GetMapping("/novo")//subrota
    public String adicionarNoticia(Model model) {//esse produto vai ser implementando/salvo no momento q eu chamar o POSt dentro daquela tela;
        model.addAttribute("noticia", new Noticia());
        return "noticia_novo";
    }

    @PostMapping("/novo")
    public String adicionar(Noticia noticia) {
        noticiaService.criar(noticia);
        return "redirect:/noticia";
    }

    ////////////////////////////////////////////////////////////////

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        noticiaService.remover(id);
        return "redirect:/noticia";
    }
    //////////////////////////////////////////////////////////////////

    @GetMapping("/editar/{id}")//@PathVariable-> essa anotação fala que tenho uma variável nela que é da linha 31 ({id});
    public String editar(@PathVariable int id, Model model){//a função do model é carregar junto com interface;
        Noticia noticia = noticiaService.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "notica_editar";
    }

    @PostMapping("/editar")
    public String editar(Noticia noticia){
        noticiaService.atualizar(noticia);
        return "redirect:/noticia";
    }


}








