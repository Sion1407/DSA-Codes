package Exercises.dsaProblems;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HackerrrankAPItest {
    public static void main(String[] args) throws IOException {
        String resp = getResponseFromURL();
        System.out.println(resp);
        JsonObject jsonObject = new Gson().fromJson(resp,JsonObject.class);
        int totalPages = jsonObject.get("total_pages").getAsInt();
        JsonArray arr = jsonObject.getAsJsonArray("data");
        JsonObject jsonObject1 = arr.get(0).getAsJsonObject();

        System.out.println(jsonObject1+" "+totalPages);
    }

    public static String getResponseFromURL() throws IOException {
        URL url = new URL("https://mocki.io/v1/5ccc9462-172c-496f-9df3-ee559a7e558e");
        HttpURLConnection con =(HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Content-Type", "application/json");
        BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String res;
        StringBuilder sb = new StringBuilder("");
        while ((res=bf.readLine())!=null ){
            sb.append(res);
        }

        return sb.toString();
    }
}
