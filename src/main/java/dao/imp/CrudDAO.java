package dao.imp;

import dao.api.Dao;
import datasource.DataSource;
import model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static dao.imp.SQLs.*;

public abstract class CrudDAO<T extends Entity<Integer>> implements Dao<Integer, T> {

    private Class<T> type;
    private DataSource dataSource;

    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";

    public CrudDAO(Class<T>  type) {
        this.type = type;
        dataSource = DataSource.getInstance();
    }

    @Override
    public List<T> getAll(){
        String sql = String.format(SELECT_ALL, type.getSimpleName());

        List<T> result = null;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();){
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public T getById(Integer id) {
        String sql = String.format(FIND_BY_ID, type.getSimpleName());

        List<T> result = null;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (result.size() > 0) ? (T) result.get(0) : null;
    }

    @Override
    public T getBy(String fieldName, String value) {
        String sql = String.format(FIND_BY, type.getSimpleName(), fieldName, value);
        Connection connection = dataSource.getConnection();
        List result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (result.size() > 0) ? (T) result.get(0) : null;
    }

    @Override
    public List<T> getAllBy(String fieldName, String value){
        String sql = String.format(FIND_BY, type.getSimpleName(), fieldName, value);
        Connection connection = dataSource.getConnection();
        List result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = createInsertStatement(connection, entity)){
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = createUpdateStatement(connection, entity)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer key) {
        String sql = String.format(DELETE_BY_ID, type.getSimpleName());

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract PreparedStatement createUpdateStatement(Connection connection, T entity) throws SQLException;

    protected abstract PreparedStatement createInsertStatement(Connection connection, T entity) throws SQLException;

    protected abstract List<T> readAll(ResultSet resultSet) throws SQLException;
}
