package com.example.firstproject.dto;

import lombok.AllArgsConstructor; // AllArgsConstructor 패키지 임포트
import lombok.ToString; // ToString 패키지 임포트
import com.example.firstproject.entity.Member;

@AllArgsConstructor // 새 어노테이션 추가
@ToString // 새 어노테이션 추가
public class MemberForm {
  private String email; // 이메일을 받을 필드
  private String password; // 비밀번호를 받을 필드

  public Member toEntity() {
    return new Member(null, email, password);
  }
}
