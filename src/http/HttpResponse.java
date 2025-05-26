package http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {
    private BufferedWriter out;
    private int status = 200;

    public HttpResponse(Socket socket) throws IOException {
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void sendJson(String json) throws IOException {
        String statusLine = "HTTP/1.1 " + status + " " + getStatusText(status) + "\r\n";
        String headers = "Content-Type: application/json\r\n" +
                         "Content-Length: " + json.length() + "\r\n\r\n";

        out.write(statusLine);
        out.write(headers);
        out.write(json);
        out.flush();
    }

    private String getStatusText(int code) {
        switch (code) {
            case 200: return "OK";
            case 400: return "Bad Request";
            case 404: return "Not Found";
            case 500: return "Internal Server Error";
            default:  return "Unknown";
        }
    }
}
