package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 선언
public class ArticleController {

  @GetMapping("/articles/new") // url 요청 접수
  public String newArticleForm() { // 메서드 생성 및 반환값 작성
    return "articles/new";
  }
}
