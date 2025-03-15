package com.example.firstproject.controller;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.repository.MemberRepository;
import com.example.firstproject.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Slf4j
@Controller
public class MemberController {

  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/members/new")
  public String newMemberForm() {
    return "members/new";
  }

  @PostMapping("/join")
  public String joinMember(MemberForm form) {
    log.info(form.toString());

    Member member = form.toEntity();
    log.info(member.toString());

    Member saved = memberRepository.save(member);
    log.info(saved.toString());
    return "articles/show";
  }

  @GetMapping("/members/{id}")
  public String show(@PathVariable Long id, Model model) { // ㄱ, ㄴ 정답
    // 1. id를 조회해 데이터 가져오기
    Member memberEntity = memberRepository.findById(id).orElse(null); // ㄷ 정답
    // 2. 모델에 데이터 등록하기
    model.addAttribute("member", memberEntity); // ㄹ 정답
    // 3. 뷰 페이지 반환하기
    return "members/show";
  }

  @GetMapping("/members")
  public String index(Model model) { // ㅁ 정답
    // 1. 모든 데이터 가져오기
    ArrayList<Member> memberEntityList = memberRepository.findAll(); // ㅂ 정답
    // 2. 모델에 데이터 등록하기
    model.addAttribute("memberList", memberEntityList); // ㅅ 정답
    // 3. 뷰 페이지 설정하기기
    return "members/index";
  }
}
