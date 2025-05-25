package service;

import dao.UserDAO;
import model.User;

//Class that manages the logic of user authentication and registration
public class AuthService {
    
    //This uses the UserDAO class that handles direct queries to the database.
    private UserDAO userDAO = new UserDAO();

    //Here you manage the business logic to search for a user in the database.
    public boolean login(String username, String password) {

        User user = userDAO.findUser(username, password);
        return user != null;

    }

    //Here you manage the business logic to register a user.
    public boolean register(String username, String email, String password) {

        if(username == null || password == null || email == null ||
            username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                return false;
        }

        User user = new User(username, email, password);
        return userDAO.register(user);
    }

}
