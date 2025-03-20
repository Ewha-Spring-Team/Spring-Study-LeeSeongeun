package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import com.example.firstproject.entity.Member;

@AllArgsConstructor
@ToString
public class MemberForm {
  private Long id; // id 필드 추가
  private String email;
  private String password;

  public Member toEntity() {
    return new Member(id, email, password);
  }
}
