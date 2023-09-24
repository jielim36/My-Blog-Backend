package com.myblog.controller;

import com.myblog.bean.Articles;
import com.myblog.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("in...");
        return articlesService.getArticleById(articleId);
    }

    @GetMapping("/total")
    public Long getTotalNumberOfArticles(){
        return articlesService.getTotalNumberOfArticles();
    }

}
