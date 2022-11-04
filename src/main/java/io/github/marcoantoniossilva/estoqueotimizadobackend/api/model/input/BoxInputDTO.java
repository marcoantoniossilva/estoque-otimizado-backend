package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BoxInputDTO {

    @NotBlank
    @Size(min=1,max=4)
    private String street;

    @NotBlank
    @Size(min=1,max=3)
    private String rack;

    @NotBlank
    @Size(min=1,max=3)
    private String column;

    @NotBlank
    @Size(min=1,max=3)
    private String line;

}
