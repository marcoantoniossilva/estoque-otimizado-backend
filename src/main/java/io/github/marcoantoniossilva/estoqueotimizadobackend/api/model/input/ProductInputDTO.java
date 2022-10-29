package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductInputDTO {

    @NotNull
    @Positive
    private Long productId;

    @NotNull
    private String description;

    @NotNull
    private String barCode;

    @NotNull
    private String boxId;

}
