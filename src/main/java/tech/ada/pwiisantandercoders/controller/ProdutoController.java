package tech.ada.pwiisantandercoders.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
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
    public ResponseEntity<ProdutoDTO> criar(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.criar(produtoDTO));
    }

    //Listar todos
    @GetMapping("/todos")
    public List<ProdutoDTO> todos() {
        return this.produtoService.todos();
    }

    @GetMapping("/por/{codigoBarra}")
    public ProdutoDTO buscarPorId(@PathVariable("codigoBarra") String codigoBarra) {
        return this.produtoService.buscaPorCodigoBarra(codigoBarra)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @PutMapping("/atualizar")
    public ProdutoDTO atualizar(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return this.produtoService.atualizar(produtoDTO);
    }

    //deletar
    @DeleteMapping("/deletar/{codigoBarra}")
    public void deletar(@PathVariable("codigoBarra") String codigoBarra) {
        this.produtoService.deletar(codigoBarra);
    }

}
