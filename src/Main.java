import service.AuthService;

public class Main {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        if(auth.register("Carlos rivera", "eee", "343")) {
            System.out.println("You are the best");
        } else {
            System.out.println("You are lost :(");
        }
    }
}
