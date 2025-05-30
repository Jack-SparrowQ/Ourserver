package model;

public class User {
    
    //main data
    private int id;
    private String username;
    private String password;
    private String email;

    //other data
    private String imgePath;
    private String bio;
    private String contact;


    public User(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public User(int id, String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setId(id);
    }

    public User() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
