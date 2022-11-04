package io.github.marcoantoniossilva.estoqueotimizadobackend.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    private static final long serialVersionUID = 1L;

    private Integer status;

    private LocalDateTime dateTime;

    private String title;

    private List<Field> fields;

    @Data
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }
}