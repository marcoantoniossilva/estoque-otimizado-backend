package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product extends BaseEntity{

  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String description;

  private String barcode;

  @ManyToOne
  @JoinColumn(name="box_id")
  private Box box;

}
