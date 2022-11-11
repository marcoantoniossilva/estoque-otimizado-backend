package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repository;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findByBoxId(Long boxId, Pageable pageable);

  Page<Product> findByDescriptionIgnoreCaseContaining(String description, Pageable pageable);

  @Query("select p.box from Product p where p.id = :productId")
  Optional<Box> getBoxById(Long productId);
}
