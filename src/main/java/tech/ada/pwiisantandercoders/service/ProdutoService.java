package tech.ada.pwiisantandercoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.converter.ProdutoConverter;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.repository.ProdutoRepository;

import javax.swing.text.html.Option;
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
    public Optional<ProdutoDTO> buscaPorCodigoBarra(String codigoBarra) {
        Optional<Produto> optionalProduto = this.produtoRepository.findByCodigoBarra(codigoBarra);
        if (optionalProduto.isPresent()) {
            return Optional.of(this.produtoConverter.toProdutoDTO(optionalProduto.get()));
        } else {
            return Optional.empty();
        }
    }

    //ATUALIZAR - UPDATE
    public ProdutoDTO atualizar(ProdutoDTO produtoDTO) {
        Optional<Produto> optionalProduto = this.produtoRepository.findByCodigoBarra(produtoDTO.getCodigoBarra());
        if (optionalProduto.isPresent()) {

            Produto produtoDB = optionalProduto.get();

            Produto produtoAtualizado = Produto.builder()
                                            .id(produtoDB.getId())
                                            .nome(produtoDTO.getNome())
                                            .codigoBarra(produtoDTO.getCodigoBarra())
                                            .descricao(produtoDTO.getDescricao())
                                            .preco(produtoDTO.getPreco())
                                            .build();

            Produto produtoAtualizadoDB = this.produtoRepository.save(produtoAtualizado);
            return this.produtoConverter.toProdutoDTO(produtoAtualizadoDB);
        }
        throw new RuntimeException("Produto inexistente");
    }

    //DELETE
    public void deletar(String codigoBarra) {
        Optional<Produto> optionalProduto = this.produtoRepository.findByCodigoBarra(codigoBarra);
        optionalProduto.ifPresent(produto -> this.produtoRepository.delete(produto));
    }

}
