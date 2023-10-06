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

    public List<Articles> getArticlesByRecommended(Integer indexOfFirstArticle , Integer articlesPerPage){
        return articlesMapper.getArticlesByRecommended(indexOfFirstArticle, articlesPerPage);
    }

    public Articles getArticleById(Long articleId){
        return articlesMapper.getArticleById(articleId);
    }

    public Long getTotalNumberOfArticles(){
        return articlesMapper.getTotalNumberOfArticles();
    }

    public Long getTotalNumberOfArticlesByTitle(String title){
        return articlesMapper.getTotalNumberOfArticlesByTitle(title);
    }

    public Long getTotalNumberOfArticlesByAuthor(Long userId){
        return articlesMapper.getTotalNumberOfArticlesByAuthor(userId);
    }

    public void updateArticleById(Long articleId ,Articles article){
        article.setArticleId(articleId);
        articlesMapper.updateArticleById(article);
    }

    public List<Articles> getTrendingArticlesByLimit(Long limit){
        return articlesMapper.getTrendingArticlesByLimit(limit);
    }
    public List<Articles> getArticlesByContent(String content){
        return articlesMapper.getArticlesByContent(content);
    }
    public List<Articles> getArticlesTitleByLimit(String title ,
                                             Integer indexOfFirstArticle,
                                             Integer articlePerPage){
        return articlesMapper.getArticlesTitleByLimit(title ,indexOfFirstArticle , articlePerPage);
    }

    public List<Articles> getArticlesByAuthorId(Long authorId){
        return articlesMapper.getArticlesByAuthorId(authorId);
    }

    public Integer createArticle(Articles articles){
        return articlesMapper.createArticle(articles);
    }

}
