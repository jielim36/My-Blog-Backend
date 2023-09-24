package com.myblog.service;

import com.myblog.bean.Articles;
import com.myblog.mapper.ArticlesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService{

    private final ArticlesMapper articlesMapper;

    @Autowired
    public ArticlesService(ArticlesMapper articlesMapper) {
        this.articlesMapper = articlesMapper;
    }

    public List<Articles> getArticlesByLatest(Integer indexOfFirstArticle , Integer articlesPerPage){
        return articlesMapper.getArticlesByLatest(indexOfFirstArticle, articlesPerPage);
    }

    public Articles getArticleById(Long articleId){
        return articlesMapper.getArticleById(articleId);
    }

    public Long getTotalNumberOfArticles(){
        return articlesMapper.getTotalNumberOfArticles();
    }

}
