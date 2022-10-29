package io.github.marcoantoniossilva.estoqueotimizadobackend.api.assembler;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.BoxDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BoxAssembler {

    private final ModelMapper modelMapper;

    public BoxAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BoxDTO entityToDTO(Box box) {
        return modelMapper.map(box, BoxDTO.class);
    }

  public Box dtoToEntity(BoxDTO boxDTO) {
    return modelMapper.map(boxDTO, Box.class);
  }

    public List<BoxDTO> collectionEntityToCollectionDTO(List<Box> boxes) {
        return boxes.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}