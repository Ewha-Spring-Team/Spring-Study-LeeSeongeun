package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.NoArgsConstructor; // @NoArgsConstructor 임포트

import java.lang.annotation.Inherited;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 추가 해주는 어노테이션
@ToString
@Entity
public class Article {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String title;
  @Column
  private String content;
}
