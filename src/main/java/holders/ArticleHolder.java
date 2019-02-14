package holders;

import dao.ArticleDao;
import entity.Article;
import spring.SpringContextHolder;

import java.util.List;

public class ArticleHolder {

    public void saveArticles(List<Article> articles) {
        ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao")).saveAll(articles);
    }

    public void saveArticle(Article art) {
        ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao")).save(art);
    }

}
