package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.DBConnection;

//This class is responsible for interacting with the database
public class UserDAO {
    
    //Method responsible for querying the existence of an entity within the database
    public static User findUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement state = conn.prepareStatement(sql);

            state.setString(1, username);
            state.setString(2, password);
            ResultSet rs = state.executeQuery();

            if(rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
                );
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

    //verify that the mail does not exist in the database
    public boolean mailExists(String mail) {

        String sql = "SELECT id FROM users WHERE email = ?";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement state = conn.prepareStatement(sql)) {

            state.setString(1, mail);
            ResultSet rs = state.executeQuery();
            return rs.next();

        }catch(SQLException e) {
            e.printStackTrace();
            return true;
        }

    }

}
