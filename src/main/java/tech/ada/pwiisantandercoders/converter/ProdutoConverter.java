package tech.ada.pwiisantandercoders.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
import tech.ada.pwiisantandercoders.model.Produto;

@Component
public class ProdutoConverter {

    public ProdutoDTO toProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        BeanUtils.copyProperties(produto, produtoDTO, "id");
        return produtoDTO;
    }

    public Produto toProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return produto;
    }

}
