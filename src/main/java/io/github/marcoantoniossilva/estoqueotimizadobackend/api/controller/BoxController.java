package io.github.marcoantoniossilva.estoqueotimizadobackend.api.controller;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.assembler.BoxAssembler;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.BoxDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.BoxInputDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils.BoxUtils;
import io.github.marcoantoniossilva.estoqueotimizadobackend.common.utils.EntityUtils;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.exception.ResourceNotFoundException;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.User;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.BoxService;
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
@RequestMapping("boxes")
public class BoxController {

    private BoxService boxService;
    private ProductService productService;
    private BoxAssembler boxAssembler;
    private EntityUtils<Box> entityUtils;

    @GetMapping
    private Page<BoxDTO> list(@PageableDefault Pageable pageable) {
        Page<Box> result = boxService.findAll(pageable);
        return boxAssembler.pageEntityToPageModel(result);
    }

    @GetMapping("search")
    public Page<BoxDTO> search(@RequestParam String searchTerm, @PageableDefault Pageable pageable) {
        Page<Box> result = boxService.findByBoxCodeIgnoreCaseContaining(searchTerm, pageable);
        return boxAssembler.pageEntityToPageModel(result);
    }

    @GetMapping("{boxId}")
    public ResponseEntity<BoxDTO> getById(@PathVariable Long boxId) {
        return boxService.findById(boxId)
                .map(box -> ResponseEntity.ok(boxAssembler.entityToDTO(box)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("byCode/{boxCode}")
    public ResponseEntity<BoxDTO> getByCode(@PathVariable String boxCode) {
        String convertedCode = BoxUtils.convertSeparator(boxCode);
        return boxService.findByCode(convertedCode)
                .map(box -> ResponseEntity.ok(boxAssembler.entityToDTO(box)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getByProductId/{productId}")
    public ResponseEntity<BoxDTO> getByProductId(@PathVariable Long productId) {
        return productService.getBoxById(productId)
                .map(box -> ResponseEntity.ok(boxAssembler.entityToDTO(box)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BoxDTO add(@Valid @RequestBody BoxInputDTO boxInputDTO) {
        Box box = boxAssembler.dtoToEntity(boxInputDTO);
        String boxCode = BoxUtils.generateBoxCodeByBoxInputDto(boxInputDTO);
        box.setCode(boxCode);

        User user = SecurityUtils.getLoggedUser();
        box.setRegisterBy(user);

        Box savedBox = boxService.save(box);
        return boxAssembler.entityToDTO(savedBox);
    }

    @PutMapping("{boxId}")
    public ResponseEntity<BoxDTO> update(@Valid @RequestBody BoxInputDTO boxInputDTO,
                                         @PathVariable Long boxId) {
        Box oldBox = boxService.findByIdOrException(boxId);

        User user = SecurityUtils.getLoggedUser();
        Box updatedBox = boxAssembler.dtoToEntity(boxInputDTO);
        updatedBox.setUpdatedBy(user);
        updatedBox.setUpdatedIn(LocalDateTime.now());
        String boxCode = BoxUtils.generateBoxCodeByBox(oldBox);
        updatedBox.setCode(boxCode);
        entityUtils.merge(updatedBox, oldBox);

        oldBox.setId(boxId);
        Box savedBox = boxService.save(oldBox);
        return ResponseEntity.ok(boxAssembler.entityToDTO(savedBox));
    }

    @DeleteMapping("{boxId}")
    public ResponseEntity<Void> delete(@PathVariable Long boxId) {
        if (!boxService.existsById(boxId)) {
            return ResponseEntity.notFound().build();
        }
        boxService.deleteById(boxId);
        return ResponseEntity.noContent().build();
    }

}
