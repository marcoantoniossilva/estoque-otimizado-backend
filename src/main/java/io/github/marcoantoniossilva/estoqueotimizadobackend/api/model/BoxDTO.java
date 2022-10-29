package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.ProductIdDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BoxDTO extends BaseModelDTO{

    private String boxId;
    private String street;
    private String rack;
    private String column;
    private String line;
    private List<ProductIdDTO> products;

}