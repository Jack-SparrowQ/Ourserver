package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//Clase encargada de leer y parsear las solicitudes HTTP del socket
public class HttpRequest {
    
    private String method;
    private String path;
    private String body;

    public HttpRequest(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        //Reading the request line (for exple: POST/register)
        String requesLine = in.readLine();
        if(requesLine == null || requesLine.isEmpty()) return;

        String[] parts = requesLine.split(" ");
        method = parts[0];
        path = parts[1];

        //Reading headers
        int contentLength = 0;
        String line;
        while(!(line = in.readLine()).isEmpty()) {
            if(line.startsWith("Content-Length")) {
                contentLength = Integer.parseInt(line.split(":")[1].trim());
            }
        }

        //Reading body (weather there is)
        if(contentLength>0) {
            char[] buffer = new char[contentLength];
            in.read(buffer,0,contentLength);
            body = new String(buffer);
        } else {
            body = "";
        }

    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getBody() {
        return body;
    }

}
