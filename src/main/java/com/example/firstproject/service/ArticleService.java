package com.example.firstproject.service;

import java.util.List;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstproject.dto.ArticleForm;

@Service // 서비스 객체 생성
public class ArticleService {
  @Autowired
  private ArticleRepository articleRepository; // 게시글 리파지터리 객체 주입

  public List<Article> index() {
    return articleRepository.findAll();
  }

  public Article show(Long id) {
    return articleRepository.findById(id).orElse(null);
  }

  public Article create(ArticleForm dto) {
    Article article = dto.toEntity(); // dto -> 엔티티로 변환한 후 article에 저장
    if (article.getId() != null) {
      return null;
    }
    return articleRepository.save(article); // article을 DB에 저장
  }
}
