package io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.BoxInputDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;

public class BoxUtils {

    public static String generateBoxCodeByBoxInputDto(BoxInputDTO boxInputDTO) {
        return boxInputDTO.getStreet()
                .concat("/")
                .concat(boxInputDTO.getRack())
                .concat("/")
                .concat(boxInputDTO.getColumn())
                .concat("/")
                .concat(boxInputDTO.getLine());
    }

    public static String generateBoxCodeByBox(Box box) {
        return box.getStreet()
                .concat("/")
                .concat(box.getRack())
                .concat("/")
                .concat(box.getColumn())
                .concat("/")
                .concat(box.getLine());
    }

    public static String convertSeparator(String oldBoxCode) {
        return oldBoxCode.replace("-","/");
    }

}
