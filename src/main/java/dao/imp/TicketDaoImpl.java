package dao.imp;

import dao.DaoFactory;
import model.Ticket;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TicketDaoImpl extends CrudDAO<Ticket> {
    private final String INSERT = "Insert into ticket (sessionId, row, seat, userId) values (?,?,?,?)";
    private final String UPDATE = "UPDATE ticket SET sessionId = ?, row = ?, seat = ? userId = ? WHERE id = ?";

    public TicketDaoImpl() {
        super(Ticket.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Ticket entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getSession().getId());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setInt(3, entity.getSeat());
        preparedStatement.setInt(4, entity.getUserId());
        preparedStatement.setInt(5, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Ticket entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getSession().getId());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setInt(3, entity.getSeat());
        preparedStatement.setInt(4, entity.getUserId());
        return preparedStatement;
    }

    @Override
    protected List<Ticket> readAll(ResultSet resultSet) throws SQLException {
        List<Ticket> result = new LinkedList<>();
        Ticket ticket = null;
        while (resultSet.next()) {
            ticket = new Ticket();
            ticket.setId(resultSet.getInt("id"));
            ticket.setSession(DaoFactory.getInstance().getSessionDao().getById(resultSet.getInt("sessionId")));
            ticket.setRow(resultSet.getInt("row"));
            ticket.setSeat(resultSet.getInt("seat"));
            ticket.setUserId(resultSet.getInt("userId"));
            result.add(ticket);
        }
        return result;
    }
}