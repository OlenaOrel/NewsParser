import dao.HibernateMySqlArticleDao;

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
        System.out.println("Enter url:");
        String url = (new Scanner(System.in).nextLine());
        switch (pacer) {
            case 1:
                new ArticleHolder().saveArticle(ParseSitePage.parseArticlePage(url));
                break;
            case 2:
                new ArticleHolder().saveArticles(ParseSitePage.parseCategoryPage(url));
                break;
            case 3:
                new ArticleHolder().saveArticles(ParseSitePage.parseMainPage(url));
                break;
            case 4:
                new HibernateMySqlArticleDao().delete();
        }

//        new ArticleHolder().saveArticles(ParseSitePage.parseCategoryPage("https://www.nytimes.com/section/opinion"));

    }
}
