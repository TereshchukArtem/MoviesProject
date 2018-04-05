package dao.imp;

import java.sql.PreparedStatement;


import dao.DaoFactory;
import model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl extends CrudDAO<User> {
    private final String INSERT = "Insert into user (login, password, firstName, lastName, email," +
            " sex, birthday, roleId) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE user SET login = ?, password = ?, firstName = ?, lastName = ?," +
            " email = ?, sex = ?, birthday = ?, roleId = ? WHERE id = ?";

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getSex());
        preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setInt(8, entity.getRole().getId());
        preparedStatement.setInt(9, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getSex());
        preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setInt(8, entity.getRole().getId());
        return preparedStatement;
    }

    @Override
    protected List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setEmail(resultSet.getString("email"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthday(resultSet.getDate("birthday").toLocalDate());
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("roleId")));
            result.add(user);
        }
        return result;
    }
}
