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

public class D3RootObject {

    public Follower getFollower(String fName) throws MalformedURLException, IOException {
        URL url = new URL("https://eu.api.battle.net/d3/data/follower/" + fName + "?locale=en_GB&apikey=q4t5bsyufrehzx4a98wazgax79tbhbur");
        try (InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            Follower follower = new Follower();
            JsonReader jsonReader = Json.createReader(in);
            JsonObject jsonObject = jsonReader.readObject();

            jsonReader.close();
            in.close();

            String name = jsonObject.getString("name");
            String realName = jsonObject.getString("realName");
            String portrait = jsonObject.getString("portrait");

            follower.setName(name);
            follower.setRealName(realName);
            follower.setPortrait(portrait);


            return follower;
        }
    }

}
