package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
  private String title; // 제목을 받을 필드
  private String content; // 내용을 받을 필드

  // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
  public ArticleForm(String title, String content) {
    this.title = title;
    this.content = content;
  }

  // 데이터를 잘 받았는지 확인할 toString() 메서드 추가
  @Override
  public String toString() {
    return "ArticleForm{" +
        "title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }

  // 폼 데이터를 담은 DTO 객체를 엔티티로 반환
  public Article toEntity() {
    return new Article(null, title, content); // 생성자 입력 양식에 맞게 작성
  }
}
