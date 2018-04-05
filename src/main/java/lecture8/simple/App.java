package lecture8.simple;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/web_cinema?useSSL=false";
    private static final String USER = "web_cinema_admin";
    private static final String PASWORD = "123";
    private static final String SQL_CREATE_HUMAN_TABLE = "CREATE TABLE IF NOT EXISTS ticket(\n" +
            "  id int AUTO_INCREMENT PRIMARY KEY,\n" +
            "  sessionId int,\n" +
            "  row INT,\n" +
            "  seat INT,\n" +
            "  userId INT\n" +
            ");";
    private static final String SQL_INSERT_HUMAN = "INSERT INTO human(name , age) VALUES (?,?)";
    private static final String SQL_READ_HUMAN = "SELECT * FROM human";

    public static void main(String[] args) {
            CreateHumanTable();
//        List<Human> humanList = new ArrayList<>();
//        humanList.add(new Human("Vasia", 25));
//        humanList.add(new Human("Sveta", 27));
//        humanList.add(new Human("Katia", 20));
//        addHumansToDB(humanList);
//        humanList.forEach(System.out::println);
//        List<Human> humanList = readHumanFromDB();
//        humanList.forEach(System.out::println);


    }

    private static List<Human> readHumanFromDB() {
        List<Human> humanList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SQL_READ_HUMAN)) {
            while (rs.next()) {
                Human human = new Human();
                human.setId(rs.getInt("id"));
                human.setName(rs.getString("name"));
                human.setAge(rs.getInt("age"));
                humanList.add(human);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return humanList;
    }


    private static void addHumansToDB(List<Human> humanList) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_HUMAN, Statement.RETURN_GENERATED_KEYS)) {
            for (Human human : humanList) {
                statement.setString(1, human.getName());
                statement.setInt(2, human.getAge());
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    human.setId(rs.getInt(1));
                    rs.close();
                }
            }
            statement.execute(SQL_CREATE_HUMAN_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void CreateHumanTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(SQL_CREATE_HUMAN_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

