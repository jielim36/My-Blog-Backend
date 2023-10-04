package com.myblog.controller;

import com.myblog.bean.Articles;
import com.myblog.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600 , origins = "http://localhost:3000")
@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private final ArticlesService articlesService;

    @Autowired
    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping("/latest/{indexOfFirstArticle}/{articlesPerPage}")
    public List<Articles> getArticlesByLatest(@PathVariable("indexOfFirstArticle") Integer indexOfFirstArticle,
                                              @PathVariable("articlesPerPage") Integer articlePerPage){
        List<Articles> articlesByLatest = articlesService.getArticlesByLatest(indexOfFirstArticle, articlePerPage);
        articlesByLatest.forEach(System.out::println);
        return articlesByLatest;
    }

    @GetMapping("/recommended/{indexOfFirstArticle}/{articlesPerPage}")
    public List<Articles> getArticlesByRecommended(@PathVariable("indexOfFirstArticle") Integer indexOfFirstArticle,
                                              @PathVariable("articlesPerPage") Integer articlePerPage){
        List<Articles> articlesByRecommended = articlesService.getArticlesByRecommended(indexOfFirstArticle, articlePerPage);
        articlesByRecommended.forEach(System.out::println);
        return articlesByRecommended;
    }

    @GetMapping("/{articleId}")
    public Articles getArticleById(@PathVariable("articleId") Long articleId){
        return articlesService.getArticleById(articleId);
    }

    @GetMapping("/total")
    public Long getTotalNumberOfArticles(){
        return articlesService.getTotalNumberOfArticles();
    }

    @GetMapping("/total/{title}")
    public Long getTotalNumberOfArticlesByTitle(@PathVariable("title")String title){
        return articlesService.getTotalNumberOfArticlesByTitle(title);
    }

    @PutMapping("/{articleId}")
    public void updateArticleById(@PathVariable("articleId")Long articleId ,
                                  @RequestBody Articles newArticle){
        System.out.println("In update view...ID:" + articleId);
        System.out.println(newArticle);
        articlesService.updateArticleById(articleId,newArticle);
    }

    @GetMapping("/trending/{limit}")
    public List<Articles> getTrendingArticles(@PathVariable("limit") Long limit){
        return articlesService.getTrendingArticlesByLimit(limit);
    }

    @GetMapping("/content/{content}")
    public List<Articles> getArticlesByContent(@PathVariable("content") String content){
        return articlesService.getArticlesByContent(content);
    }

    @GetMapping("/title/{title}/{indexOfFirstArticle}/{articlesPerPage}")
    public List<Articles> getArticlesByTitle(@PathVariable("title") String title,
                                             @PathVariable("indexOfFirstArticle") Integer indexOfFirstArticle,
                                             @PathVariable("articlesPerPage") Integer articlePerPage){
        return articlesService.getArticlesTitleByLimit(title,indexOfFirstArticle,articlePerPage);
    }

    @GetMapping("/author/{authorId}")
    public List<Articles> getArticlesByAuthorId(@PathVariable("authorId") Long authorId){
        return articlesService.getArticlesByAuthorId(authorId);
    }
}
