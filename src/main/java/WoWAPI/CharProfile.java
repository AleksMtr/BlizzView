package WoWAPI;

public class CharProfile {
    protected String name;
    protected String realm;
    protected String battlegroup;
    protected String thumbnail;
    protected int charClass;
    protected int race;
    protected int gender;
    protected int level;
    protected int achPoints;
    protected int faction;
    protected int totalHonorableKills;
    protected String items;
    protected int avglvl;
    
    public CharProfile() {
    }
    
    public String getItems()
    {
        return items;
    }
    public void setItems(String items)
    {
        this.items = items;
    }
    public int getAvglvl()
    {
        return avglvl;
    }
    public void setAvglvl(int avglvl)
    {
        this.avglvl = avglvl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getTotalHonorableKills() {
        return totalHonorableKills;
    }

    public void setTotalHonorableKills(int totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public int getCharClass() {
        return charClass;
    }

    public void setCharClass(int charClass) {
        this.charClass = charClass;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAchPoints() {
        return achPoints;
    }

    public void setAchPoints(int achPoints) {
        this.achPoints = achPoints;
    }

    public int getFaction() {
        return faction;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }
}
