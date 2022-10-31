package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.service;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoxService extends BaseCrudService<Box,String> {

    Page<Box> findByBoxIdContaining(String term, Pageable pageable);

}
