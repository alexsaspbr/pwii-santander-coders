package tech.ada.pwiisantandercoders.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
import tech.ada.pwiisantandercoders.model.Produto;

@Component
public class ProdutoConverter {

    public ProdutoDTO toProdutoDTO(Produto produto) {
        //ProdutoDTO produtoDTO = new ProdutoDTO();
        //BeanUtils.copyProperties(produto, produtoDTO, "id");
        //return produtoDTO;
        return ProdutoDTO.builder()
                  .codigoBarra(produto.getCodigoBarra())
                  .nome(produto.getNome())
                  .descricao(produto.getDescricao())
                  .preco(produto.getPreco())
                .build();
    }

    public Produto toProduto(ProdutoDTO produtoDTO){
        //Produto produto = new Produto();
        //BeanUtils.copyProperties(produtoDTO, produto);
        //return produto;
        return Produto.builder()
                .codigoBarra(produtoDTO.getCodigoBarra())
                .nome(produtoDTO.getNome())
                .descricao(produtoDTO.getDescricao())
                .preco(produtoDTO.getPreco())
                .build();
    }

}
