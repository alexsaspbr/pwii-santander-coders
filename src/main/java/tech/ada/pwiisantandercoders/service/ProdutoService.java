package tech.ada.pwiisantandercoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //INSERT - CREATE
    public Produto criar(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    //BUSCAR - READ - TODOS
    public List<Produto> todos() {
        return this.produtoRepository.findAll();
    }

    //BUSCAR - READ - BUSCAR POR ID
    public Optional<Produto> buscarPorId(Long id){
        return this.produtoRepository.findById(id);
    }

    //ATUALIZAR - UPDATE
    public Produto atualizar(Produto produto){
        Optional<Produto> optionalProduto = this.buscarPorId(produto.getId());
        if(optionalProduto.isPresent()) {
            return this.produtoRepository.save(optionalProduto.get());
        }
        throw new RuntimeException("Produto inexistente");
    }

    //DELETE
    public void deletar(Long id){
        this.produtoRepository.deleteById(id);
    }

}
