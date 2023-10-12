package tech.ada.pwiisantandercoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.pwiisantandercoders.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
