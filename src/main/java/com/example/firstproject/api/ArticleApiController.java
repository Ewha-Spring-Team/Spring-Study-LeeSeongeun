package com.example.firstproject.api;

import java.util.List;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleApiController {
  @Autowired // 게시글 리파지터리 주입
  private ArticleRepository articleRepository;

  // GET
  @GetMapping("/api/articles")
  public List<Article> index() {
    return articleRepository.findAll();
  }
}
