package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.dto.ArticleForm;

@Controller // 컨트롤러 선언
public class ArticleController {

  @GetMapping("/articles/new") // url 요청 접수
  public String newArticleForm() { // 메서드 생성 및 반환값 작성
    return "articles/new";
  }

  // 폼 데이터를 post 방식으로 전송했으므로 받을 때도 PostMapping으로 받음
  @PostMapping("/articles/create") // url 요청 접수
  public String createArticle(ArticleForm form) { // 폼 데이터를 DTO로 받기
    System.out.println(form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인
    return ""; // 형식을 맞추기 위해 return 값에는 빈 문자
  }
}
