package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoxRepository extends JpaRepository<Box, Long> {

  Page<Box> findByCodeIgnoreCaseContaining(String boxId, Pageable pageable);

  Long countByCodeIgnoreCaseContaining(String boxId);

  Optional<Box> findByCode(String boxCode);

  boolean existsByCode(String boxCode);

  void deleteByCode(String boxCode);

}
