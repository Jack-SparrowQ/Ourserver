package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.DBConnection;

public class UserDAO {
    
    public User findUser(String username, String password) {

        String sql = "SELECT * FROM user WHERE lastname = ? AND password = ?";

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

}
