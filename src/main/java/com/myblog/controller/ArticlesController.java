package com.myblog.controller;

import com.myblog.bean.Articles;
import com.myblog.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return articlesService.getArticlesByLatest(indexOfFirstArticle, articlePerPage);
    }

    @GetMapping("/{articleId}")
    public Articles getArticleById(@PathVariable("articleId") Long articleId){
        return articlesService.getArticleById(articleId);
    }

    @GetMapping("/total")
    public Long getTotalNumberOfArticles(){
        return articlesService.getTotalNumberOfArticles();
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

}
