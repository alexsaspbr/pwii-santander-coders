package tech.ada.pwiisantandercoders.dto;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    @NotNull(message = "Campo codigo de barra é obrigatório")
    @Pattern(regexp = "(\\D)+", message = "Permitido somente números")
    private String codigoBarra;
    private String descricao;
    @NegativeOrZero(message = "Preço não pode ser negativo ou zerado")
    private BigDecimal preco;

}
