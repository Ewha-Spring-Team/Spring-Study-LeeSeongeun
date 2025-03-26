package com.example.firstproject.api;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.service.ArticleService;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Slf4j
@RestController

public class ArticleApiController {
  @Autowired
  private ArticleService articleService; // 서비스 객체 주입

  // GET
  @GetMapping("/api/articles")
  public List<Article> index() {
    return articleService.index();
  }

  @GetMapping("/api/articles/{id}")
  public Article show(@PathVariable Long id) {
    return articleService.show(id);
  }

  // POST
  @PostMapping("/api/articles")
  public ResponseEntity<Article> create(@RequestBody ArticleForm dto) { // 서비스로 게시글 생성
    Article created = articleService.create(dto); // 객체 이름 변경
    return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created)
        : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  // PATCH
  @PatchMapping("/api/articles/{id}")
  public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
    Article updated = articleService.update(id, dto); // 서비스를 통해 게시글 수정
    return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated)
        : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  // DELETE
  @DeleteMapping("/api/articles/{id}")
  public ResponseEntity<Article> delete(@PathVariable Long id) {
    Article deleted = articleService.delete(id);
    return (deleted != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }
}
