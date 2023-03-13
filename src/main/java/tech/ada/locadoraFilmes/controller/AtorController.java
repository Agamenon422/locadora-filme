package tech.ada.locadoraFilmes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.ada.locadoraFilmes.model.Ator;
import tech.ada.locadoraFilmes.model.Filme;
import tech.ada.locadoraFilmes.service.AtorService;

import java.util.List;

@Controller
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @GetMapping("/novo")
    public String novoAtor(Model model){
        model.addAttribute("ator", new Ator());
        return "ator_novo";
    }
    @PostMapping("/novo")
    public String adicionar(Ator ator){
        atorService.criar(ator);
        return "redirect:/ator";
    }

    ///////////////////////////////////////////////////////////////////////////

    @GetMapping
    public String listar(Model model){
        List<Ator> atores = atorService.buscar();
        model.addAttribute("ator", atores);
        return "ator_listar";
    }

    ///////////////////////////////////////////////////////////////////////////

    @GetMapping("editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Ator ator = atorService.buscarPorId(id);
        model.addAttribute("ator", ator);
        return "ator_editar";
    }
    @PostMapping("/editar")
    public String editar(Ator ator){
        atorService.atualizar(ator);
        return "redirect:/ator";
    }

    ////////////////////////////////////////////////////////////////////////////





@GetMapping("/remover/{id}")
    public String remover(@PathVariable int id){
        atorService.remover(id);
        return "redirect:/ator";
    }





}
