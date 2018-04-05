package dao.imp;

import dao.DaoFactory;
import model.Session;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SessionDaoImpl extends CrudDAO<Session> {
    private final String INSERT = "Insert into session (deliveryTime, price, movieId, hallId) values (?,?,?,?)";
    private final String UPDATE = "UPDATE session SET deliveryTime = ?, price = ?, movieId = ?, hallId = ? WHERE id = ?";

    public SessionDaoImpl() {
        super(Session.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Session entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setTime(1, Time.valueOf(entity.getDeliveryTime().toString()));
        preparedStatement.setInt(2,entity.getPrice());
        preparedStatement.setInt(3, entity.getMovie().getId());
        preparedStatement.setInt(4, entity.getHall().getId());
        preparedStatement.setInt(5, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Session entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setTime(1, Time.valueOf(entity.getDeliveryTime().toString()));
        preparedStatement.setInt(2,entity.getPrice());
        preparedStatement.setInt(3, entity.getMovie().getId());
        preparedStatement.setInt(4, entity.getHall().getId());
        return preparedStatement;
    }

    @Override
    protected List<Session> readAll(ResultSet resultSet) throws SQLException {
        List<Session> result = new LinkedList<>();
        Session session = null;
        while (resultSet.next()) {
            session = new Session();
            session.setId(resultSet.getInt("id"));
            session.setDeliveryTime(resultSet.getTime("deliveryTime"));
            session.setPrice(resultSet.getInt("price"));
            session.setMovie(DaoFactory.getInstance().getMovieDao().getById(resultSet.getInt("movieId")));
            session.setHall(DaoFactory.getInstance().getHallDao().getById(resultSet.getInt("hallId")));
            result.add(session);
        }
        return result;
    }
}