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
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter // 롬복으로 Getter 추가
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // RB가 id 자동 생성성
  private Long id;
  @Column
  private String title;
  @Column
  private String content;

  public void patch(Article article) {
    if (article.title != null) {
      this.title = article.title;
    }
    if (article.content != null) {
      this.content = article.content;
    }
  }
}
