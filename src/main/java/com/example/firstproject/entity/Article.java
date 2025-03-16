package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Getter;

import java.lang.annotation.Inherited;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter // 롬복으로 Getter 추가
public class Article {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String title;
  @Column
  private String content;
}
