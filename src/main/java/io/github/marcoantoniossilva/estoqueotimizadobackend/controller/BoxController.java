package io.github.marcoantoniossilva.estoqueotimizadobackend.controller;


import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repsitory.BoxRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("caixas")
public class BoxController {

  private BoxRepository boxRepository;

  @GetMapping()
  public List<Box> list(){
    return boxRepository.findAll();
  }

  @GetMapping("{boxId}")
  public List<Box> findByBoxIdContaining(@RequestParam String boxId){
    return boxRepository.findByBoxIdContaining(boxId);
  }

}
