package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class Movie extends Entity<Integer>{
    private String title;
    private String genre;
    private String description;
    private long duration;
    private LocalDate startRelease;
    private LocalDate finishRelease;
    private String posterUrl;
    private String trailerUrl;

    public Movie(String title, String genre, String description, long duration, LocalDate startRelease,
                 LocalDate finishRelease, String posterUrl, String trailerUrl) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.startRelease = startRelease;
        this.finishRelease = finishRelease;
        this.posterUrl = posterUrl;
        this.trailerUrl = trailerUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "description='" + description + '\'' +
                ", id=" + getId() +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return duration == movie.duration &&
                Objects.equals(title, movie.title) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(startRelease, movie.startRelease) &&
                Objects.equals(finishRelease, movie.finishRelease) &&
                Objects.equals(posterUrl, movie.posterUrl) &&
                Objects.equals(trailerUrl, movie.trailerUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), title, genre, description, duration, startRelease, finishRelease, posterUrl, trailerUrl);
    }
}
