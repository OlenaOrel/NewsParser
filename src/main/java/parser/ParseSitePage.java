package parser;

import entity.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ParseSitePage {

    public List<Article> getArticlesFromMainPage(String mainUrl) {
        List<Article> out = new LinkedList<Article>();
        try {
            Document doc = Jsoup.connect(mainUrl).get();
            for (Element element : doc.getElementsByClass("css-6p6lnl")) {
                out.add(getArticleFromArticlePage(element.select("a").attr("abs:href")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    Set<String> getCategoryPages(String url) throws IOException {
        Set<String> out = new HashSet<String>();
        Document doc = Jsoup.connect(url).get();
        for (Element element : doc.getElementsByClass("css-y3otqb e134j7ei0")) {
            out.add(element.attr("abs:href"));
        }
        return out;
    }

    public List<Article> getArticlePageFromCategoryPage(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        List<Article> out = new LinkedList<Article>();
        for (Element element : doc.getElementsByClass("css-10wtrbd")) {
            out.add(getArticleFromArticlePage(element.select("a").attr("abs:href")));
        }
        return out;
    }


    public Article getArticleFromArticlePage(String url) {
        String title = "";
        String text = "";
        String date = "";
        try {
            Document doc = Jsoup.connect(url).get();
            for (Element element : doc.getElementsByClass("css-1w5cs23 epjyd6m2")) {
                date = element.getElementsByAttribute("datetime").text();
            }
            for (Element element : doc.getElementsByAttributeValue("id", "story")) {
                title = element.getElementsByAttributeValue("itemprop", "headline").text();
                text = element.getElementsByClass("css-53u6y8").text();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Article(title, date, text);
    }

}
