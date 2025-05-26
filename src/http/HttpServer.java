package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    
    private int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Server is running on port ["+port+"]");

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleClient(socket)).start();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    private void handleClient(Socket socket) {
        try {
            HttpRequest request = new HttpRequest(socket);
            HttpResponse response = new HttpResponse(socket);
            Router.route(request,response);
            socket.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
