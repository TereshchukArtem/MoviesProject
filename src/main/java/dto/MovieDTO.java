package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Entity;

import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class MovieDTO extends Entity<Integer> {
    private String title;
    private String genre;
    private String description;
    private long duration;
    private LocalDate startRelease;
    private LocalDate finishRelease;
    private String posterUrl;
    private String trailerUrl;

    public MovieDTO(String title, String genre, String description, long duration,
                    LocalDate startRelease, LocalDate finishRelease, String posterUrl, String trailerUrl) {
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
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", startRelease=" + startRelease +
                ", finishRelease=" + finishRelease +
                ", posterUrl='" + posterUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return duration == movieDTO.duration &&
                Objects.equals(title, movieDTO.title) &&
                Objects.equals(genre, movieDTO.genre) &&
                Objects.equals(description, movieDTO.description) &&
                Objects.equals(startRelease, movieDTO.startRelease) &&
                Objects.equals(finishRelease, movieDTO.finishRelease) &&
                Objects.equals(posterUrl, movieDTO.posterUrl) &&
                Objects.equals(trailerUrl, movieDTO.trailerUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), title, genre, description, duration, startRelease, finishRelease, posterUrl, trailerUrl);
    }
}
