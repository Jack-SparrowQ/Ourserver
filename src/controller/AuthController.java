package controller;
import java.io.IOException;

import org.json.JSONObject;

import dao.UserDAO;
import http.HttpRequest;
import http.HttpResponse;
import model.User;
import service.AuthService;

//Clase encargada de conectarse a AuthService
public class AuthController {
    
    public static void register(HttpRequest request, HttpResponse response) throws IOException{
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
                System.out.println("El que hizo la peticion se registro");
            } else {
                response.setStatus(400);
                response.sendJson("{\"error\":\"No se pudo registrar el usuario\"}");
                                System.out.println("El que hizo la peticion no se registro");

            }


        }catch(Exception e) {
            response.setStatus(500);
            response.sendJson("{\"Error\":\"Internal error into Server\"}");
        }
    }

    //This method es el encargado de validar el login exitoso.
    public static void login(HttpRequest request, HttpResponse response) throws IOException {
        
        try {
            JSONObject body = new JSONObject(request.getBody());

            String username = body.optString("username");
            String password = body.optString("password");

            User user = UserDAO.findUser(username,password);

            if (user != null) {
                JSONObject res = new JSONObject();
                res.put("message", "Welcome");
                res.put("userID", user.getId());
                res.put("username", user.getUsername());

                response.setStatus(200);
                response.sendJson(res.toString());
                System.out.println("Permitido adelante");
            } else {
                JSONObject error = new JSONObject();
                error.put("error", "Credentials invalible");
                response.setStatus(400);
                response.sendJson("{\"error\":\"The user do not exist or credentials invalaible\"}");
                System.out.println("El user no paso el Login");
            }

        } catch(Exception e) {
            response.setStatus(500);
            response.sendJson("{\"Error\":\"Internal error into Server\"}");
        }
 
    }

}
