package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import com.example.firstproject.entity.Article;

@AllArgsConstructor
@ToString
public class ArticleForm {
  private Long id; // id 필드 추가
  private String title;
  private String content;

  public Article toEntity() {
    return new Article(id, title, content); // null -> id로 수정
  }
}
