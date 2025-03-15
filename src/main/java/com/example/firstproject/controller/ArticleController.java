package com.example.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Slf4j
@Controller
public class ArticleController {

  @Autowired
  private ArticleRepository articleRepository;

  @GetMapping("/articles/new")
  public String newArticleForm() {
    return "articles/new";
  }

  @GetMapping("/articles/{id}") // id를 변수로!
  public String show(@PathVariable Long id, Model model) {
    log.info("id = " + id);
    // 1. id를 조회해 데이터 가져오기
    Article articleEntity = articleRepository.findById(id).orElse(null);
    // 2. 모델에 데이터 등록하기
    model.addAttribute("article", articleEntity);
    // 3. 뷰 페이지 반환하기
    return "articles/show";
  }

  @PostMapping("/articles/create")
  public String createArticle(ArticleForm form) {
    log.info(form.toString());

    Article article = form.toEntity();
    log.info(article.toString());

    Article saved = articleRepository.save(article);
    log.info(saved.toString());

    return "";
  }
}
