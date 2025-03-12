package com.example.firstproject.entity;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // 이 클래스가 엔티티임을 선언
public class Member {
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String email;
  @Column
  private String password;

  // Member 생성자 추가
  public Member(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  // 오버라이드
  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
