package com.example.firstproject.entity;

import java.lang.annotation.Inherited;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Member {
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String email;
  @Column
  private String password;
}
