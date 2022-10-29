package io.github.marcoantoniossilva.estoqueotimizadobackend.api.controller;

import io.github.marcoantoniossilva.estoqueotimizadobackend.api.assembler.BoxAssembler;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.BoxDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.api.model.input.BoxInputDTO;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.User;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service.BoxService;
import io.github.marcoantoniossilva.estoqueotimizadobackend.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("boxes")
public class BoxController {

  private BoxService boxService;
  private BoxAssembler boxAssembler;

  @GetMapping
  private Page<BoxDTO> list(@PageableDefault Pageable pageable) {
    Page<Box> result = boxService.findAll(pageable);
    return boxAssembler.pageEntityToPageModel(result);
  }

  @GetMapping("search")
  public Page<BoxDTO> search(@RequestParam String searchTerm, @PageableDefault Pageable pageable) {
    Page<Box> result = boxService.findByIdContaining(searchTerm, pageable);
    return boxAssembler.pageEntityToPageModel(result);
  }

  @GetMapping("{boxId}")
  public ResponseEntity<BoxDTO> getById(@PathVariable String boxId) {
    return boxService.findById(boxId)
            .map(box -> ResponseEntity.ok(boxAssembler.entityToDTO(box)))
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/getByProductId/{productId}")
  public ResponseEntity<BoxDTO> getById(@PathVariable Long productId) {
    return boxService.findByProductId(productId)
            .map(box -> ResponseEntity.ok(boxAssembler.entityToDTO(box)))
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  private BoxDTO add(@Valid @ModelAttribute BoxInputDTO boxInputDTO) {

    User user = SecurityUtils.getLoggedUser();
    Box box = boxAssembler.dtoToEntity(boxInputDTO);
    box.setRegisterBy(user);

    Box savedBox = boxService.save(box);
    return boxAssembler.entityToDTO(savedBox);
  }

  @PutMapping("{boxId}")
  public ResponseEntity<BoxDTO> update(@Valid @ModelAttribute BoxInputDTO boxInputDTO,
                                       @PathVariable String boxId) {
    if (!boxService.existsById(boxId)) {
      return ResponseEntity.notFound().build();
    }

    boxInputDTO.setBoxId(boxId);
    User user = SecurityUtils.getLoggedUser();
    Box box = boxAssembler.dtoToEntity(boxInputDTO);
    box.setUpdatedBy(user);

    Box savedBox = boxService.save(box);
    return ResponseEntity.ok(boxAssembler.entityToDTO(savedBox));
  }

  @DeleteMapping("{boxId}")
  public ResponseEntity<Void> delete(@PathVariable String boxId) {
    if (!boxService.existsById(boxId)) {
      return ResponseEntity.notFound().build();
    }
    boxService.deleteById(boxId);
    return ResponseEntity.noContent().build();
  }

}
