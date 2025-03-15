package com.example.firstproject.entity;

import java.lang.annotation.Inherited;

import lombok.AllArgsConstructor;
import lombok.ToString;
import javax.annotation.processing.Generated;
import lombok.NoArgsConstructor; // @NoArgsConstructor 임포트

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 추가 해주는 어노테이션
@ToString
@Entity // 이 클래스가 엔티티임을 선언
public class Member {
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String email;
  @Column
  private String password;
}
