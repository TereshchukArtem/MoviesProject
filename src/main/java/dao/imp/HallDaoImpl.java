package dao.imp;

import dao.DaoFactory;
import model.Hall;
import model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class HallDaoImpl extends CrudDAO<Hall> {
private final String INSERT = "Insert into hall (name, planUrl, row, seat) values (?,?,?,?)";
private final String UPDATE = "UPDATE hall SET name = ?, planUrl = ?, row = ?, seat = ? WHERE id = ?";

        public HallDaoImpl() {
                super(Hall.class);
        }

@Override
protected PreparedStatement createUpdateStatement(Connection connection, Hall entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getPlanUrl());
        preparedStatement.setInt(3, entity.getRow());
        preparedStatement.setInt(4, entity.getSeat());
        preparedStatement.setInt(5, entity.getId());
        return preparedStatement;
        }

@Override
protected PreparedStatement createInsertStatement(Connection connection, Hall entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getPlanUrl());
        preparedStatement.setInt(3, entity.getRow());
        preparedStatement.setInt(4, entity.getSeat());
        return preparedStatement;
            }

private void setStatement(Hall entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getPlanUrl());
        preparedStatement.setInt(3, entity.getRow());
        preparedStatement.setInt(4, entity.getSeat());
            }


@Override
protected List<Hall> readAll(ResultSet resultSet) throws SQLException {
        List<Hall> result = new LinkedList<>();
        Hall hall = null;
        while (resultSet.next()) {
        hall = new Hall();
        hall.setId(resultSet.getInt("id"));
        hall.setName(resultSet.getString("name"));
        hall.setPlanUrl(resultSet.getString("planUrl"));
        hall.setRow(resultSet.getInt("row"));
        hall.setSeat(resultSet.getInt("seat"));
        result.add(hall);
        }
        return result;
        }
}
