package io.github.marcoantoniossilva.estoqueotimizadobackend.api.model;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.UserIdDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseModelDTO {

    private LocalDateTime registerIn;
    private UserIdDTO registerBy;
    private LocalDateTime updatedIn;
    private UserIdDTO updatedBy;

}
