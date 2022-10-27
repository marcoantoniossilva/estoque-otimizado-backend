package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name="boxes")
public class Box extends BaseEntity{

  @EqualsAndHashCode.Include
  @Id
  @Column(name="id_box")
  private String boxId;

  private String street;

  private String rack;

  @Column(name="box_column")
  private String column;

  private String line;

  @OneToMany(mappedBy = "box")
  private List<Product> products;

}
