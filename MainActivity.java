package com.example.movies_3;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMovies();
    }

    private void loadMovies() {
        try {
            List<Movie> movies = JsonUtils.loadMovies(this);

            Toast.makeText(this, "Movies loaded: " + movies.size(), Toast.LENGTH_LONG).show();

            if (movies.isEmpty()) {
                showError("No movies found");
                return;
            }

            adapter = new MovieAdapter(movies);
            recyclerView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
            showError("Error loading movies");
        }
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}