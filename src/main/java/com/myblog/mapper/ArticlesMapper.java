package com.myblog.mapper;

import com.myblog.bean.Articles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticlesMapper {

    List<Articles> getArticlesByLatest(@Param("indexOfFirstArticle") Integer indexOfFirstArticle,
                                       @Param("articlesPerPage") Integer articlesPerPage);

    Articles getArticleById(@Param("articleId") Long articleId);

    Long getTotalNumberOfArticles();

}
