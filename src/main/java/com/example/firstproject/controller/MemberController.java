package com.example.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.repository.MemberRepository;
import com.example.firstproject.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j // 로깅 기능을 위한 어노테이션 추가
@Controller // 컨트롤러 선언
public class MemberController {

  @Autowired // 스프링 부트가 미리 생성한 둔 리파지터리 객체 주입
  private MemberRepository memberRepository;

  @GetMapping("/members/new") // url 요청 접수
  public String newMemberForm() { // 메서드 생성 및 반환값 작성
    return "members/new"; // members/new 페이지를 반환
  }

  // 폼 데이터를 받아오는 작업
  @PostMapping("/join") // url 요청 접수
  public String joinMember(MemberForm form) {
    log.info(form.toString());

    // DTO를 엔티티로 변환
    Member member = form.toEntity();
    log.info(member.toString());

    // 리파지터리로 엔티티를 DB에 저장
    Member saved = memberRepository.save(member);
    log.info(saved.toString());
    return "";
  }
}
