package com.example.firstproject.entity;

import java.lang.annotation.Inherited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // 이 클래스가 엔티티임을 선언하기 위해 어노테이션을 붙임
public class Article {

  @Id // 엔티티의 대푯값 지정(제목과 내용이 같더라도 대푯값으로 다른 글임을 구분 가능)
  @GeneratedValue // 자동 생성 기능 추가(숫자가 자동으로 매겨짐)
  private Long id;
  @Column // title 필드 선언, DB 테이블의 title 열과 연결됨
  private String title;

  // Article 생성자 추가
  public Article(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  // toString() 메서드 추가
  @Override
  public String toString() {
    return "Article{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }

  @Column // content 필드 선언, DB 테이블의 content 열과 연결됨
  private String content;
}
