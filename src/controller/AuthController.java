package controller;

import org.json.JSONObject;
import http.HttpRequest;
import http.HttpResponse;
import service.AuthService;

//Clase encargada de conectarse a AuthService
public class AuthController {
    
    public static void register(HttpRequest request, HttpResponse response) {
        try {
            JSONObject json = new JSONObject(request.getBody());
            String username = json.getString("username");
            String password = json.getString("password");
            String email = json.getString("email");

            AuthService service = new AuthService();
            boolean success = service.register(username, email, password);

            if (success) {
                response.setStatus(200);
                response.sendJson("{\"message\":\"Usuario registrado correctamente\"}");
            } else {
                response.setStatus(400);
                response.sendJson("{\"error\":\"No se pudo registrar el usuario\"}");
            }


        }catch(Exception e) {
            response.setStatus(500);
            //response.sendJson("{\"Error\":\"Internal error into Server\"}");
        }
    }

}
