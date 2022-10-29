package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoxRepository extends JpaRepository<Box, String> {

  Page<Box> listByBoxIdContaining(String boxId, Pageable pageable);

  Optional<Box> findByBoxIdContaining(String boxId);

  Optional<Box> findByProductId(Long productId);

  Long countByBoxIdContaining(String boxId);

}
