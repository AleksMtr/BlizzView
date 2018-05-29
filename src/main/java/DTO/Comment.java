package DTO;

public class Comment {
    private int commID;
    private int cAuthor;
    private int artID;
    private String commText;
    private String published;
    
    public Comment(int commID, int cAuthor, int artID, String commText, String published){
        this.commID = commID;
        this.cAuthor = cAuthor;
        this.artID = artID;
        this.commText = commText;
        this.published = published;
    }
    
    public Comment(){
    }

    public int getCommID() {
        return commID;
    }

    public int getcAuthor() {
        return cAuthor;
    }

    public int getArtID() {
        return artID;
    }

    public String getCommText() {
        return commText;
    }

    public String getPublished() {
        return published;
    }

    public void setCommID(int commID) {
        this.commID = commID;
    }

    public void setcAuthor(int cAuthor) {
        this.cAuthor = cAuthor;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public void setCommText(String commText) {
        this.commText = commText;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.commID;
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
        final Comment other = (Comment) obj;
        if (this.commID != other.commID) {
            return false;
        }
        return true;
    }
    
    
}
