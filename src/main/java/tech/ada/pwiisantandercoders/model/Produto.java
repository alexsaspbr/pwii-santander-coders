package tech.ada.pwiisantandercoders.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String codigoBarra;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal preco;

}
