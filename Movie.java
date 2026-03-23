package com.example.movies_3;

import android.content.Context;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String poster;

    public Movie(String title, int year, String genre, String poster) {
        this.title = (title != null) ? title : "Unknown";
        this.year = (year > 0) ? year : 0;
        this.genre = (genre != null) ? genre : "Unknown";
        this.poster = poster;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    public int getPosterResourceId(Context context) {
        if (poster == null) return R.drawable.placeholder;

        int resId = context.getResources()
                .getIdentifier(poster, "drawable", context.getPackageName());

        return (resId != 0) ? resId : R.drawable.placeholder;
    }
}