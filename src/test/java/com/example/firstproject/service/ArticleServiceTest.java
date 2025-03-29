package com.example.firstproject.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import com.example.firstproject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*; // 앞으로 사용할 수 있는 패키지 임포트

@SpringBootTest // 해당 클래스를 스프링 부트와 연동해 테스트
class ArticleServiceTest {
  @Autowired
  ArticleService articleService; // articleService 객체 주입

  @Test
  void index() {
    // 1. 예상 데이터
    Article a = new Article(1L, "가가가가", "1111");
    Article b = new Article(2L, "나나나나", "2222");
    Article c = new Article(3L, "다다다다", "3333");
    List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
    // 2. 실제 데이터
    List<Article> articles = articleService.index();

    // 3. 비교 및 검증
    assertEquals(expected.toString(), articles.toString());
  }

}
