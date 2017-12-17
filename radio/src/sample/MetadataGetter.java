package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class MetadataGetter {
    String result = "";
    public MetadataGetter(){

    }
    public String getTitle(){
        System.out.println("metadata getTitle");
        JsonElement jelement = null;
        try {
            String out = new Scanner(new URL("http://wnuq.pl:8000/status-json.xsl").openStream(), "UTF-8").useDelimiter("\\A").next();
            jelement = new JsonParser().parse(out);
            JsonObject  jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("icestats");
            JsonArray jarray = jobject.getAsJsonArray("source");
            jobject = jarray.get(0).getAsJsonObject();
            result = jobject.get("title").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
