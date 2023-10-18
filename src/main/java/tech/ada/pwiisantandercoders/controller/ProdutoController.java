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
    @GetMapping("/todos")
    public List<Produto> todos() {
        return this.produtoService.todos();
    }

    @GetMapping("/por/{id}")
    public Produto buscarPorId(@PathVariable("id") Long id) {
        return this.produtoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @PutMapping("/atualizar")
    public Produto atualizar(@RequestBody Produto produto) {
        return this.produtoService.atualizar(produto);
    }

    //deletar

}
