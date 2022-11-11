package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class ProductInputDTO {

    @NotBlank
    private String description;

    @NotBlank
    @Size(min=1,max=13)
    private String barCode;

    @NotNull
    private Long boxId;

}
