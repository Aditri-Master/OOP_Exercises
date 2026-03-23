package com.example.movies_3;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;
        ImageView poster;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            year = view.findViewById(R.id.year);
            genre = view.findViewById(R.id.genre);
            poster = view.findViewById(R.id.poster);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.title.setText(movie.getTitle());
        holder.year.setText("Year: " + movie.getYear());
        holder.genre.setText("Genre: " + movie.getGenre());

        holder.poster.setImageResource(
                movie.getPosterResourceId(holder.itemView.getContext())
        );
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}