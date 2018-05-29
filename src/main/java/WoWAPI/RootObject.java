package WoWAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class RootObject {
    
    public CharProfile getChar(String realm, String name) throws MalformedURLException, IOException
    {
        URL url = new URL("https://eu.api.battle.net/wow/character/"+realm+"/"+name+"?locale=en_GB&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
        try (InputStream in = url.openStream(); 
            BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            CharProfile cProf = new CharProfile();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
            int classID = jsonObject.getInt("class");
            int race = jsonObject.getInt("race");
            int gender = jsonObject.getInt("gender");
            int level = jsonObject.getInt("level");
            String thumbnail = jsonObject.getString("thumbnail");
            String battlegroup = jsonObject.getString("battlegroup");
            int totalHonorableKills = jsonObject.getInt("totalHonorableKills");
            
            cProf.setThumbnail(thumbnail);
            cProf.setCharClass(classID);
            cProf.setBattlegroup(battlegroup);
            cProf.setRealm(realm);
            cProf.setName(name);
            cProf.setLevel(level);
            cProf.setRace(race);
            cProf.setGender(gender);
            cProf.setTotalHonorableKills(totalHonorableKills);
            cProf.setThumbnail(thumbnail);
            return cProf;
        }
    }
}
