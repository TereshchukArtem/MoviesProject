package dao.imp;

import model.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public final class MovieDaoImpl extends CrudDAO<Movie> {
    private final String INSERT = "Insert into movie (title, genre, description, duration, startRelease," +
            " finishRelease, posterUrl, trailerUrl) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE movie SET title = ?, genre = ?, description = ?, duration = ?, startRelease = ?," +
            " finishRelease = ?, posterUrl = ?, trailerUrl = ? WHERE id = ?";
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
        preparedStatement.setDate(5, Date.valueOf(entity.getStartRelease().toString()));
        preparedStatement.setDate(6,  Date.valueOf(entity.getFinishRelease().toString()));
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
        preparedStatement.setDate(5, Date.valueOf(entity.getStartRelease().toString()));
        preparedStatement.setDate(6, Date.valueOf(entity.getFinishRelease().toString()) );
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
            movie.setStartRelease(resultSet.getDate("startRelease").toLocalDate());
            movie.setFinishRelease(resultSet.getDate("finishRelease").toLocalDate());
            movie.setPosterUrl(resultSet.getString("posterUrl"));
            movie.setTrailerUrl(resultSet.getString("trailerUrl"));
            result.add(movie);
        }
        return result;
    }

}
