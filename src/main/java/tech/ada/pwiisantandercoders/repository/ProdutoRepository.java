package tech.ada.pwiisantandercoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.pwiisantandercoders.model.Produto;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //SELECT * FROM TB_PRODUTO WHERE CODIGO_BARRA =: CODIGO_BARRA
    Optional<Produto> findByCodigoBarra(String codigoBarra);

    void deleteByCodigoBarra(String codigoBarra);
}
