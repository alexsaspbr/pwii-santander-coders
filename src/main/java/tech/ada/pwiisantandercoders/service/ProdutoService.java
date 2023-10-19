package tech.ada.pwiisantandercoders.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.converter.ProdutoConverter;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoConverter produtoConverter;

    //INSERT - CREATE
    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = this.produtoConverter.toProduto(produtoDTO);
        Produto produtoDB = this.produtoRepository.save(produto);
        return this.produtoConverter.toProdutoDTO(produtoDB);
    }

    //BUSCAR - READ - TODOS
    public List<ProdutoDTO> todos() {
        return this.produtoRepository.findAll().stream()
                .map(produto -> this.produtoConverter.toProdutoDTO(produto))
                .collect(Collectors.toList());
    }

    //BUSCAR - READ - BUSCAR POR ID
/*    public Optional<Produto> buscarPorId(Long id){
        return this.produtoRepository.findById(id);
    }*/

/*    //ATUALIZAR - UPDATE
    public Produto atualizar(Produto produto){
        Optional<Produto> optionalProduto = this.buscarPorId(produto.getId());
        if(optionalProduto.isPresent()) {

            Produto produtoDB = optionalProduto.get();

            Produto produtoAtualizado = new Produto(produtoDB.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());

            return this.produtoRepository.save(produtoAtualizado);
        }
        throw new RuntimeException("Produto inexistente");
    }*/

    //DELETE
/*    public void deletar(Long id){
        this.produtoRepository.deleteById(id);
    }*/

}
