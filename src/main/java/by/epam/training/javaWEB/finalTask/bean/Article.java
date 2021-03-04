package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Article implements Serializable {
    private int idUser;
    private String title;
    private Timestamp date;
    private String link;

    public Article() {
    }

    public Article(int idUser, String title, Timestamp date, String link) {
        this.idUser = idUser;
        this.title = title;
        this.date = date;
        this.link = link;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return idUser == article.idUser &&
                title.equals(article.title) &&
                date.equals(article.date) &&
                link.equals(article.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, title, date, link);
    }

    @Override
    public String toString() {
        return "Article{" +
                "idUser=" + idUser +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", link='" + link + '\'' +
                '}';
    }
}
