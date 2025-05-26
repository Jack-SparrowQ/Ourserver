package http;

import java.io.IOException;

import controller.AuthController;
//Aqui se define la logica para cada ruta, y
//delega,ps al controlador
public class Router {
    
    //Establecer el metodo Router para comunicar
    //con HttpRequest y HttpResponse
    public static void route(HttpRequest request, HttpResponse response) throws IOException {


        String method = request.getMethod();
        String path = request.getPath();

        //test
        System.out.println("Method: "+method+", Path: "+path);

        if(path.equals("/register") && method.equals("POST")) {
            AuthController.register(request, response);
        } else if(path.equals("/register") && method.equals("GET")) {
            response.setStatus(200);
            response.sendJson("{\"info\":\"Usa POST para registrar un usuario.\"}");
        }else if(path.equals("/") && method.equals("GET")) {
            response.setStatus(200);
            response.sendJson("{\"messege\":\"Server is ready\"}");
        } else {
            response.setStatus(404);
            response.sendJson("{\"error\":\"Route not foud\"}");
        }

    }

}
