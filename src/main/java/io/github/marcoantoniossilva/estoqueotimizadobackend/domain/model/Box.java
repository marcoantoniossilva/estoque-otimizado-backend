package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name="boxes")
public class Box {

  @EqualsAndHashCode.Include
  @Id
  @Column(name="id_box")
  private Long boxId;

  private String street;

  private String rack;

  @Column(name="box_column")
  private String column;

  private String line;

}
