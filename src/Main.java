import http.HttpServer;

public class Main {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(8080);
        server.start();
    }
}
