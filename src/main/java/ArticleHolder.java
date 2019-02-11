import dao.HibernateMySqlArticleDao;
import entity.Article;

import java.util.List;

public class ArticleHolder {

    void saveArticles(List<Article> articles) {
        for (Article art : articles) {
            new HibernateMySqlArticleDao().save(art);
        }
    }

    void saveArticle(Article art) {
        new HibernateMySqlArticleDao().save(art);
    }

}
