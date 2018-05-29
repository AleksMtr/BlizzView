package D3API;

public class Follower {
    protected String slug;
    protected String name;
    protected String realName;
    protected String portrait;

    public Follower(String name, String realName, String portrait) {
        this.name = name;
        this.realName = realName;
        this.portrait = portrait;
    }

    public Follower() {
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    
}
