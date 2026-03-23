package com.example.movies_3;

import android.content.Context;
import org.json.*;
import java.io.*;
import java.util.*;

public class JsonUtils {

    public static List<Movie> loadMovies(Context context) {
        List<Movie> movies = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("movies.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder json = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            JSONArray array = new JSONArray(json.toString());

            for (int i = 0; i < array.length(); i++) {
                try {
                    JSONObject obj = array.getJSONObject(i);

                    String title = obj.optString("title", "Unknown");
                    int year = parseYear(obj.opt("year"));
                    String genre = obj.optString("genre", "Unknown");
                    String poster = obj.optString("poster", null);

                    movies.add(new Movie(title, year, genre, poster));

                } catch (Exception e) {
                    e.printStackTrace(); // skip bad item
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }

    private static int parseYear(Object yearObj) {
        try {
            if (yearObj instanceof Integer) return (int) yearObj;
            if (yearObj instanceof String) return Integer.parseInt((String) yearObj);
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
}