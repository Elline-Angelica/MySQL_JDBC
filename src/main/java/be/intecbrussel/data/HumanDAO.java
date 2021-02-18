package be.intecbrussel.data;

import be.intecbrussel.config.DBHelper;
import be.intecbrussel.model.Human;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HumanDAO {

    private String url;
    private String user;
    private String password;

    public void setConfig(String url, String username, String password){
        this.url = url;
        this.user = username;
        this.password = password;
    }

    public void saveHuman(Human human) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DBHelper.URL, DBHelper.user, DBHelper.password)) {
            Statement statement = connection.createStatement();
            System.out.println("Connection is completed");

            String query = String.format("INSERT INTO Human (name, lastname, gender) VALUES ('%s','%s','%s')",
                    human.getName(), human.getLastname(), human.getGender());

            statement.execute(query);    //executeQuery = bij SELECT statement

        }
    }

    public List<Human> getAllHumans() throws SQLException {

        List<Human> humanList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement statement = connection.createStatement()) {
            System.out.println("Connection is completed");

            String query = "SELECT * FROM Human";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String gender = rs.getString("gender");

                Human person = new Human(name, lastname, gender);
                humanList.add(person);
            }
        }
        return humanList;
    }
}

