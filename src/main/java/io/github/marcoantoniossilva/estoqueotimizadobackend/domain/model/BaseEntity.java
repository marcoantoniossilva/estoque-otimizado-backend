package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.Data;

import javax.persistence.*;
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

  @PrePersist
  public void prePersist(){
    this.registerIn = LocalDateTime.now();
  }
}
