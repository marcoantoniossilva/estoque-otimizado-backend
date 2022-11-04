package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="boxes")
public class Box extends BaseEntity{

  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String code;

  private String street;

  private String rack;

  @Column(name="box_column")
  private String column;

  private String line;

  @OneToMany(mappedBy = "box")
  private List<Product> products;

}
