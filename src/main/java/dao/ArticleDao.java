package dao;

import entity.Article;

import java.util.List;

public interface ArticleDao {

    void save(Article article);

    void saveAll(List<Article> articles);

}
