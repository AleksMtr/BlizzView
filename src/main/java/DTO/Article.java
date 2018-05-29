package DTO;

import java.util.Objects;

public class Article implements Comparable<Article> {

    private int artID;
    private int authorID;
    private String title;
    private String articleText;
    private String game;
    private String published;

    public Article(int artID, int authorID, String title, String articleText, String published) {
        this.artID = artID;
        this.authorID = authorID;
        this.title = title;
        this.articleText = articleText;
        this.published = published;
    }
    public Article() {
    }

    public int getArtID() {
        return artID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getTitle() {
        return title;
    }

    public String getArticleText() {
        return articleText;
    }

    public String getGame() {
        return game;
    }

    public String getPublished() {
        return published;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.artID;
        hash = 29 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.artID != other.artID) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Article a) {
        if (this.artID > a.artID) {
            return +1;
        }
        if (this.artID < a.artID) {
            return -1;
        } else {
            return 0;
        }
    }

}
