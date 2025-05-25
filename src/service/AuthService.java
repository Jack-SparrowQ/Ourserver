package service;

import dao.UserDAO;
import model.User;

public class AuthService {
    
    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) {

        User user = userDAO.findUser(username, password);
        return user != null;

    }

}
