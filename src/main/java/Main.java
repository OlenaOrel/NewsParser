import dao.ArticleDao;
import dao.HibernateMySqlArticleDao;
import parser.ParseSitePage;
import spring.SpringContextHolder;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter what do you want:");
        System.out.println("1 - save 1 article page");
        System.out.println("2 - save articles from one of category page");
        System.out.println("3 - save articles from main page");
        System.out.println("4 - Clear article table");

        int pacer = new Scanner(System.in).nextInt();
        switch (pacer) {
            case 1:
                System.out.println("Enter url:");
                String url = (new Scanner(System.in).nextLine());
                ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao"))
                        .save(((ParseSitePage) SpringContextHolder.getContext().getBean("parse")).getArticleFromArticlePage(url));
                break;
            case 2:
                System.out.println("Enter url:");
                String url1 = (new Scanner(System.in).nextLine());
                ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao"))
                        .saveAll(((ParseSitePage) SpringContextHolder.getContext().getBean("parse")).getArticlePageFromCategoryPage(url1));
                break;
            case 3:
                System.out.println("Enter url:");
                String url2 = (new Scanner(System.in).nextLine());
                ((ArticleDao) SpringContextHolder.getContext().getBean("articleDao"))
                        .saveAll(((ParseSitePage) SpringContextHolder.getContext().getBean("parse")).getArticlesFromMainPage(url2));
                break;
            case 4:
                ((HibernateMySqlArticleDao) SpringContextHolder.getContext().getBean("hib_util")).delete();
        }
    }
}
