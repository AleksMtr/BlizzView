package D3API;

import java.util.ArrayList;

public class Skills {
    ArrayList<String> slug = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> icon = new ArrayList<>();
    ArrayList<Integer> level = new ArrayList<>();
    ArrayList<String> tooltipUrl = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();

    public Skills() {
    }

    public ArrayList<String> getSlug() {
        return slug;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<String> getIcon() {
        return icon;
    }

    public ArrayList<Integer> getLevel() {
        return level;
    }

    public ArrayList<String> getTooltipUrl() {
        return tooltipUrl;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setSlug(ArrayList<String> slug) {
        this.slug = slug;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public void setIcon(ArrayList<String> icon) {
        this.icon = icon;
    }

    public void setLevel(ArrayList<Integer> level) {
        this.level = level;
    }

    public void setTooltipUrl(ArrayList<String> tooltipUrl) {
        this.tooltipUrl = tooltipUrl;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }


}
