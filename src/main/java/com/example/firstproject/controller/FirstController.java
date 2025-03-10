package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller // 컨트롤러 선언
public class FirstController {

  @GetMapping("/hi") // 클라이언트로부터 "/hi"라는 요청을 받아 접수

  // "hi"라는 요청을 받음과 동시에 niceToMeetYou() 메서드를 수행
  public String niceToMeetYou(Model model) { // 모델 객체를 매개변수로 가져옴
    model.addAttribute("username", "seongeun"); // 모델에서 사용할 변수를 등록
    return "greetings"; // 메서드를 수행한 결과로 greetings.mustache 파일을 반환
  }

  @GetMapping("/bye") // 클라이언트로부터 "/bye"라는 요청을 받아 접수

  // 메서드 작성
  public String seeYouNext(Model model) { // 모델 객체를 매개변수로 가져옴
    model.addAttribute("nickname", "홍길동"); // 모델 변수 등록
    return "goodbye"; // goodbye.mustache 반환
  }

}
