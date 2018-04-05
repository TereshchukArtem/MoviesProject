package dao.imp;

import model.Role;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoleDaoImpl extends CrudDAO<Role> {
    private final String INSERT = "Insert into role (name) values (?)";
    private final String UPDATE = "UPDATE role SET name = ? WHERE id = ?";

    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Role entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Role entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getName());
        return preparedStatement;
    }

    @Override
    protected List<Role> readAll(ResultSet resultSet) throws SQLException {
        List<Role> result = new LinkedList<>();
        Role role = null;
        while (resultSet.next()) {
            role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setName(resultSet.getString("name"));
            result.add(role);
        }
        return result;
    }
}
