import http.HttpServer;

public class Main {
    public static void main(String[] args) {
        int port = 8080;

        HttpServer server = new HttpServer(port);
        server.start();
    }
}
