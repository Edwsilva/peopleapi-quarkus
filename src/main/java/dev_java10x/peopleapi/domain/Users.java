package dev_java10x.peopleapi.domain;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table (name = "tb_users")
public class Users extends PanacheEntityBase{

  @Id 
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  public String username;
  public String email;

  public UUID getId() {
    return id;
  }
}
