package holders;

import dao.ArticleDao;
import entity.Article;
import spring.SpringContextHolder;

import java.util.List;

public class ArticleHolder {

    public void saveArticles(List<Article> articles) {
        for (Article art : articles) {
            ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao")).save(art);
        }
    }

    public void saveArticle(Article art) {
        ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao")).save(art);
    }

}
