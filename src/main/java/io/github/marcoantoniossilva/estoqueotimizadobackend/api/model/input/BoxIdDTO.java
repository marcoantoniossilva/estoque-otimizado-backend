package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class BoxIdDTO {

  @NotBlank
  @Positive
  private Long id;

}