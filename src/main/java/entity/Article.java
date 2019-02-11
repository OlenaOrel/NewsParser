package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "title")
    private String title;
    private String date;
    private String text;


    public Article() {
    }

    public Article(String title, String date, String text) {
        this.title = title;
        this.date = date;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
