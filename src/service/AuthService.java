package service;

import java.util.regex.Pattern;

import dao.UserDAO;
import model.User;

//Class that manages the logic of user authentication and registration
public class AuthService {
    
    //This uses the UserDAO class that handles direct queries to the database.
    private UserDAO userDAO = new UserDAO();

    private final Pattern emailRegex = Pattern.compile("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private final Pattern usernameRegex = Pattern.compile("^[A-Za-z]\\w{5,29}$");

    //Here you manage the business logic to search for a user in the database.
    public boolean login(String username, String password) {

        User user = userDAO.findUser(username, password);
        return user != null;

    }

    //Here you manage the business logic to register a user.
    public boolean register(String username, String email, String password) {

        if(!usernameRegex.matcher(username).matches()) {
            return false;
        }

        if(password.length() < 6) {
            return false;
        }

        if(!emailRegex.matcher(email).matches()) {
            return false;
        }

        if(userDAO.mailExists(email)) {
            return false;
        }

        User user = new User(username, email, password);
        return userDAO.register(user);
    }



}
