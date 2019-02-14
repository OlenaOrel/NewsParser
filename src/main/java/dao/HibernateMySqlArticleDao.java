package dao;

import entity.Article;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import spring.SpringContextHolder;

import java.util.List;

public class HibernateMySqlArticleDao implements ArticleDao {

    public void save(Article article) {
        Session s = ((HibernateUtil) SpringContextHolder.getContext().getBean("hib_util")).getSessionFactory().openSession();
        s.beginTransaction();
        s.save(article);
        s.getTransaction().commit();
        s.close();
    }

    public void saveAll(List<Article> articles){
        Session s = ((HibernateUtil) SpringContextHolder.getContext().getBean("hib_util")).getSessionFactory().openSession();
        s.beginTransaction();
        for (Article article : articles) {
            s.save(article);
        }
        s.getTransaction().commit();
        s.close();
    }

    public void delete() {
        Session s = ((HibernateUtil) SpringContextHolder.getContext().getBean("hib_util")).getSessionFactory().openSession();
        s.beginTransaction();
        List<Article> out = s.createQuery("FROM Article").list();
        for (Article article : out) {
            s.delete(article);
        }
        s.getTransaction().commit();
        s.close();
    }

}
