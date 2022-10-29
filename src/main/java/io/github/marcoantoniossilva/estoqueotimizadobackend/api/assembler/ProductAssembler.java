package io.github.marcoantoniossilva.estoqueotimizadobackend.api.assembler;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.ProductDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.ProductInputDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductAssembler {

    private final ModelMapper modelMapper;

    public ProductAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO entityToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

  public Product dtoToEntity(ProductDTO productDTO) {
    return modelMapper.map(productDTO, Product.class);
  }

    public Product dtoToEntity(ProductInputDTO productInputDTO) {
        return modelMapper.map(productInputDTO, Product.class);
    }

    public List<ProductDTO> collectionEntityToCollectionDTO(List<Product> products) {
        return products.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public Page<ProductDTO> pageEntityToPageModel(Page<Product> result) {
        return result.map(this::entityToDTO);
    }
}