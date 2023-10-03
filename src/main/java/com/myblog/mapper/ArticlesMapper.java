package com.myblog.mapper;

import com.myblog.bean.Articles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticlesMapper {

    List<Articles> getArticlesByLatest(@Param("indexOfFirstArticle") Integer indexOfFirstArticle,
                                       @Param("articlesPerPage") Integer articlesPerPage);

    List<Articles> getArticlesByRecommended(@Param("indexOfFirstArticle") Integer indexOfFirstArticle,
                                       @Param("articlesPerPage") Integer articlesPerPage);

    Articles getArticleById(@Param("articleId") Long articleId);

    Long getTotalNumberOfArticles();

    Long getTotalNumberOfArticlesByTitle(@Param("title")String title);

    Long getTotalNumberOfArticlesByAuthor(@Param("authorId")Long authorId);

    void updateArticleById(Articles article);

    List<Articles> getTrendingArticlesByLimit(@Param("limit")Long limit);

    List<Articles> getArticlesByContent(@Param("content")String content );

    List<Articles> getArticlesTitleByLimit(@Param("title")String title,
                                      @Param("indexOfFirstArticle") Integer indexOfFirstArticle,
                                      @Param("articlesPerPage") Integer articlesPerPage);

    List<Articles> getArticlesByAuthorId(@Param("authorId")Long authorId);

}
