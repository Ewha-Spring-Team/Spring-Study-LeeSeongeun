package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;

public class MemberForm {
  private String email; // 이메일을 받을 필드
  private String password; // 비밀번호를 받을 필드

  // 전송받은 이메일과 비밀번호를 필드에 저장하는 생성자 추가]
  public MemberForm(String email, String password) {
    this.email = email;
    this.password = password;
  }

  // 데이터를 잘 받았는지 확인할 toString() 메서드 추가
  @Override
  public String toString() {
    return "MemberForm{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  public Member toEntity() {
    return new Member(null, email, password);
  }
}
