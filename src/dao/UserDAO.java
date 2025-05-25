package dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.DBConnection;

//This class is responsible for interacting with the database
public class UserDAO {
    
    //Method responsible for querying the existence of an entity within the database
    public User findUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE lastname = ? AND password = ?";

        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement state = conn.prepareStatement(sql);

            state.setString(1, username);
            state.setString(2, password);
            ResultSet rs = state.executeQuery();

            if(rs.next()) {
                User user = new User();
                user.setUsername(username);

                return user;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    //Method responsible for registering a new profile
    public boolean register(User user) {

        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement state = conn.prepareStatement(sql)) {
                
                state.setString(1, user.getUsername());
                state.setString(2, user.getEmail());
                state.setString(3, user.getPassword());

                int rowsInserted = state.executeUpdate();
                return rowsInserted > 0;

        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
