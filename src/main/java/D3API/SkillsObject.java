/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D3API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author AleksMtr
 */
public class SkillsObject {
    
    public Skills getSkills(String fName) throws MalformedURLException, IOException {
        URL url = new URL("https://eu.api.battle.net/d3/data/follower/" + fName + "?locale=en_GB&apikey=q4t5bsyufrehzx4a98wazgax79tbhbur");
        try (InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {

            Skills skill = new Skills();
            
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();

            JsonArray skillsArr = jsonObject.getJsonArray("skills");
            int arraysize = skillsArr.size();
            ArrayList<String> allNames = new ArrayList();
            ArrayList<Integer> allLevels = new ArrayList();
            ArrayList<String> allDescriptions = new ArrayList();
            for (int i = 0; i < arraysize; i++) {
                allNames.add(skillsArr.getJsonObject(i).getJsonString("name").toString());
                skill.setName(allNames);
                allLevels.add(skillsArr.getJsonObject(i).getInt("level"));
                skill.setLevel(allLevels);
                allDescriptions.add(skillsArr.getJsonObject(i).getJsonString("description").toString());
                skill.setDescription(allDescriptions);
            }
            return skill;
        }
    }
}
