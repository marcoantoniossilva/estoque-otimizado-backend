package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.BoxIdDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDTO extends BaseModelDTO{

    private Long productId;
    private String description;
    private String barCode;
    private BoxIdDTO box;

}