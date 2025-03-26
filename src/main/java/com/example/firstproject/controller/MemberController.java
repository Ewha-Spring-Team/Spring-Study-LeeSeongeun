package com.example.firstproject.controller;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    return "redirect:/members/" + saved.getId();
  }

  @GetMapping("/members/{id}")
  public String show(@PathVariable Long id, Model model) {
    // 1. id를 조회해 데이터 가져오기
    Member memberEntity = memberRepository.findById(id).orElse(null); // ㄷ 정답
    // 2. 모델에 데이터 등록하기
    model.addAttribute("member", memberEntity);
    // 3. 뷰 페이지 반환하기
    return "members/show";
  }

  @GetMapping("/members")
  public String index(Model model) {
    // 1. 모든 데이터 가져오기
    ArrayList<Member> memberEntityList = memberRepository.findAll(); // ㅂ 정답
    // 2. 모델에 데이터 등록하기
    model.addAttribute("memberList", memberEntityList);
    // 3. 뷰 페이지 설정하기기
    return "members/index";
  }

  @GetMapping("/members/{id}/edit")
  public String edit(@PathVariable Long id, Model model) {
    // 수정할 데이터 가져오기
    Member memberEntity = memberRepository.findById(id).orElse(null);
    // 모델에 데이터 등록하기
    model.addAttribute("member", memberEntity);
    // 뷰 페이지 설정하기
    return "members/edit";
  }

  @PostMapping("/join/update")
  public String update(MemberForm form) { // 매개변수로 dto 받아오기
    log.info(form.toString());
    // 1. DTO를 엔티티로 변환하기
    Member memberEntity = form.toEntity();
    log.info(memberEntity.toString());
    // 2. 엔티티를 DB에 저장하기
    // 2-1. DB에서 기존 데이터 가져오기
    Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
    // 2-2. 기존 데이터 값을 갱신하기
    if (target != null) {
      memberRepository.save(memberEntity);
    }
    // 3. 수정 결과 페이지로 리다이렉트하기
    return "redirect:/members/" + memberEntity.getId();
  }

  @GetMapping("members/{id}/delete")
  public String delete(@PathVariable Long id, RedirectAttributes rttr) {
    log.info("삭제 요청이 들어왔습니다!!");
    // 1. 삭제할 대상 가져오기
    Member target = memberRepository.findById(id).orElse(null);
    log.info(target.toString());
    // 2. 대상 엔티티 삭제하기
    if (target != null) { // 삭제할 대상이 있는지 확인
      memberRepository.delete(target); // delete() 메서드로 대상 삭제
      rttr.addFlashAttribute("msg", "삭제되었습니다.");
    }
    // 3. 결과 페이지로 리다이렉트하기
    return "redirect:/members";
  }
}
