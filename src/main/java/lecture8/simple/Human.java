package lecture8.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Human {
    private int id;
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
/*
public final class MovieDaoImpl extends CrudDAO<Movie> {
    private final String INSERT = "Insert into movie (title, genre, description, duration, startRelease," +
            " finishRelease, posterUrl, trailerUrl) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE movie SET title = ?, genre = ?, description = ?, duration = ?, startRelease = ?," +
            " finishRelease = ?, posterUrl = ?, trailerUrl = ?,WHERE id = ?";
    private static MovieDaoImpl crudDAO;

    private MovieDaoImpl(Class type) {
        super(type);
    }


    public static synchronized MovieDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new MovieDaoImpl(Movie.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getGenre());
        preparedStatement.setString(3, entity.getDescription());
        preparedStatement.setLong(4, entity.getDuration());
        preparedStatement.setDate(5, (java.sql.Date) entity.getStartRelease());
        preparedStatement.setDate(6, (java.sql.Date) entity.getFinishRelease());
        preparedStatement.setString(7, entity.getPosterUrl());
        preparedStatement.setString(8, entity.getTrailerUrl());
        preparedStatement.setInt(9, entity.getId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getGenre());
        preparedStatement.setString(3, entity.getDescription());
        preparedStatement.setLong(4, entity.getDuration());
        preparedStatement.setDate(5, (java.sql.Date) entity.getStartRelease());
        preparedStatement.setDate(6, (java.sql.Date) entity.getFinishRelease());
        preparedStatement.setString(7, entity.getPosterUrl());
        preparedStatement.setString(8, entity.getTrailerUrl());
        return preparedStatement;
    }

    @Override
    public List<Movie> readAll(ResultSet resultSet) throws SQLException {
        List<Movie> result = new LinkedList<>();
        Movie movie = null;
        while (resultSet.next()) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setGenre(resultSet.getString("genre"));
            movie.setDescription(resultSet.getString("description"));
            movie.setDuration(resultSet.getLong("duration"));
            movie.setStartRelease(resultSet.getDate("startRelease"));
            movie.setFinishRelease(resultSet.getDate("finishRelease"));
            movie.setPosterUrl(resultSet.getString("posterUrl"));
            movie.setTrailerUrl(resultSet.getString("trailerUrl"));
            result.add(movie);
        }
        return result;
    }

}
________________________________________

@Setter
@Getter
@NoArgsConstructor
public class MovieDTO extends Entity<Integer> {

    private String title;
    private String genre;
    private String description;
    private long duration;
    private Date startRelease;
    private Date finishRelease;
    private String posterUrl;
    private String trailerUrl;

    public MovieDTO(String title, String genre, String description,
                    long duration, Date startRelease, Date finishRelease, String posterUrl, String trailerUrl) {
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
__________________________________________________

@Setter
@Getter
@NoArgsConstructor
public class Movie extends Entity<Integer>{

    private String title;
    private String genre;
    private String description;
    private long duration;
    private Date startRelease;
    private Date finishRelease;
    private String posterUrl;
    private String trailerUrl;

    public Movie(String title, String genre, String description, long duration, Date startRelease,
                 Date finishRelease, String posterUrl, String trailerUrl) {
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
________________________________________________

public class MovieServiceImpl implements Service<Integer, MovieDTO> {

    private static MovieServiceImpl service;
    private Dao<Integer, Movie> movieDao;
    private BeanMapper beanMapper;

    private MovieServiceImpl() {
        movieDao = DaoFactory.getInstance().getMovieDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized MovieServiceImpl getInstance() {
        if (service == null) {
            service = new MovieServiceImpl();
        }
        return service;
    }


    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieDao.getAll();
        List<MovieDTO> movieDTOs = beanMapper.listMapToList(movies, MovieDTO.class);
        return movieDTOs;
    }

    @Override
    public void save(MovieDTO movieDto) {
        Movie movie = beanMapper.singleMapper(movieDto, Movie.class);
        movieDao.save(movie);
    }

    @Override
    public MovieDTO getById(Integer id) {
        Movie movie = movieDao.getById(id);
        MovieDTO movieDTO = beanMapper.singleMapper(movie, MovieDTO.class);
        return movieDTO;
    }


    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(MovieDTO entity) {

    }

}
 */
