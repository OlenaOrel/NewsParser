import entity.Article;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ParseSitePage {

    static List<Article> parseMainPage(String mainUrl) {
        List<String> tmp = new LinkedList<String>();
        List<Article> out = new LinkedList<Article>();
        Document doc = null;
        try {
            doc = DocumentHolder.getConnection(mainUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element element : doc.getElementsByClass("css-6p6lnl")) {
            tmp.add(element.select("a").attr("abs:href"));

        }
        for (String url : tmp) {
            out.add(parseArticlePage(url));
        }
        return out;
    }

    static List<Article> getAllArticle(String url) throws IOException {
        Set<String> tmp = new HashSet<String>();
        Document doc = null;
        try {
            doc = DocumentHolder.getConnection(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element element : doc.getElementsByClass("css-y3otqb e134j7ei0")) {
            tmp.add(element.attr("abs:href"));
        }

        List<Article> out = new LinkedList<Article>();
        for (String url1 : tmp) {
            for (Article article : parseCategoryPage(url1)) {
                out.add(article);
            }
        }
        return out;
    }

    static List<Article> parseCategoryPage(String url) throws IOException {
        Document doc = DocumentHolder.getConnection(url);
        Set<String> tmp = new HashSet<String>();
        for (Element element : doc.getElementsByClass("css-10wtrbd")) {
            tmp.add(element.select("a").attr("abs:href"));
        }
        List<Article> out = new LinkedList<Article>();
        for (String url1 : tmp) {
            out.add(parseArticlePage(url1));
        }
        return out;
    }


    static Article parseArticlePage(String url) {
        Document doc = null;
        try {
            doc = DocumentHolder.getConnection(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = "";
        String date = "";
        for (Element element : doc.getElementsByAttributeValue("name", "articleBody")) {
            text = element.text();
        }

        String title = doc.title();
        for (Element element : doc.getElementsByTag("header")) {
            date = element.getElementsByTag("time").text();
        }
        return new Article(title, date, text);
    }

}