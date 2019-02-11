package dao;

import entity.Article;
import hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateMySqlArticleDao implements ArticleDao {

    public void save(Article article) {
        Session s = HibernateUtils.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(article);
        s.getTransaction().commit();
        s.close();
    }

    public void delete() {
        Session s = HibernateUtils.getSessionFactory().openSession();
        s.beginTransaction();
        List<Article> out = s.createQuery("FROM Article").list();
        for (Article article : out) {
            s.delete(article);
        }
        s.getTransaction().commit();
        s.close();
    }

}
