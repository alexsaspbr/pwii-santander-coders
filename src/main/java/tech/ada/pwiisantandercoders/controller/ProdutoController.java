package tech.ada.pwiisantandercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //POST - Criar
    //GET  - Buscar
    //PUT/PATCH  - Atualizar
    //DELETE     - Deletar

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    //@PostMapping(value = "/criar")
    public Produto criar(@RequestBody Produto produto) {
        return this.produtoService.criar(produto);
    }


    //Listar todos
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Produto> todos() {
        return this.produtoService.todos();
    }
}
