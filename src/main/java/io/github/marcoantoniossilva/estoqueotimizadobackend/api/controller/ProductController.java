package io.github.marcoantoniossilva.estoqueotimizadobackend.api.controller;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.assembler.ProductAssembler;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.ProductDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.ProductInputDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils.EntityUtils;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.User;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.ProductService;
import io.github.marcoantoniossilva.estoqueotimizadobackend.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;
    private ProductAssembler productAssembler;
    private EntityUtils<Product> entityUtils;


    @GetMapping
    private Page<ProductDTO> list(@PageableDefault Pageable pageable) {
        Page<Product> result = productService.findAll(pageable);
        return productAssembler.pageEntityToPageModel(result);
    }

    @GetMapping("search")
    public Page<ProductDTO> search(@RequestParam String searchTerm, @PageableDefault Pageable pageable) {
        Page<Product> result = productService.findByDescriptionIgnoreCaseContaining(searchTerm, pageable);
        return productAssembler.pageEntityToPageModel(result);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long productId) {
        return productService.findById(productId)
                .map(product -> ResponseEntity.ok(productAssembler.entityToDTO(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listByBoxId/{boxId}")
    public Page<ProductDTO> listByBoxId(@PathVariable Long boxId, @PageableDefault Pageable pageable) {
        Page<Product> pageProducts = productService.findByBoxBoxId(boxId, pageable);
        return productAssembler.pageEntityToPageModel(pageProducts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ProductDTO add(@Valid @RequestBody ProductInputDTO productInputDTO) {

        User user = SecurityUtils.getLoggedUser();
        Product product = productAssembler.dtoToEntity(productInputDTO);
        product.setRegisterBy(user);

        Product savedProduct = productService.save(product);
        return productAssembler.entityToDTO(savedProduct);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductInputDTO productInputDTO,
                                             @PathVariable Long productId) {
        if (!productService.existsById(productId)) {
            return ResponseEntity.notFound().build();
        }
        Product oldProduct = productService.findByIdOrException(productId);

        User user = SecurityUtils.getLoggedUser();
        Product updatedProduct = productAssembler.dtoToEntity(productInputDTO);
        updatedProduct.setUpdatedBy(user);
        updatedProduct.setUpdatedIn(LocalDateTime.now());
        entityUtils.merge(updatedProduct, oldProduct);

        oldProduct.setId(productId);
        Product savedProduct = productService.save(oldProduct);
        return ResponseEntity.ok(productAssembler.entityToDTO(savedProduct));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> delete(@PathVariable Long productId) {
        if (!productService.existsById(productId)) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }

}
