import service.AuthService;

public class Main {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        if(auth.login("smile", "1234")) {
            System.out.println("You are the best");
        } else {
            System.out.println("You are lost :(");
        }
    }
}
