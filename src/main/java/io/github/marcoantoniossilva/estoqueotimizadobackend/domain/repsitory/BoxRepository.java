package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.repsitory;

import io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

  List<Box> findByBoxIdContaining(String boxId);

}
