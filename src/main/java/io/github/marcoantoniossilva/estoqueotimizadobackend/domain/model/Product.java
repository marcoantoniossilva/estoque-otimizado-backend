package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name="boxes")
public class Product extends BaseEntity{

  @EqualsAndHashCode.Include
  @Id
  @Column(name="id_product")
  private Long productId;

  private String description;

  private String barcode;

  @ManyToOne
  private Box box;

}
