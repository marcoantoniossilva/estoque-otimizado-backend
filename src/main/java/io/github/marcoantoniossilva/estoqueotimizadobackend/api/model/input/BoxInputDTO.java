package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BoxInputDTO {

    private String boxId;

    @NotNull
    private String street;

    @NotNull
    private String rack;

    @NotNull
    private String column;

    @NotNull
    private String line;

}
