package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

  @Column(name = "register_in")
  private LocalDateTime registerIn;

  @ManyToOne
  @JoinColumn(name = "register_by")
  private User registerBy;

  @Column(name = "updated_in")
  private LocalDateTime updatedIn;

  @ManyToOne
  @JoinColumn(name = "updated_by")
  private User updatedBy;
}
