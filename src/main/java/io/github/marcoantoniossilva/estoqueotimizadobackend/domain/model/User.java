package io.github.marcoantoniossilva.estoqueotimizadobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @EqualsAndHashCode.Include
  @Id
  @Column(name="id_user")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  private String name;

  private String email;

  private String password;

}
