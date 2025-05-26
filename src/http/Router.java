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

        if(path.equals("/register") && method.equals("POST")) {
            AuthController.register(request, response);
        } else {
            response.setStatus(404);
            response.sendJson("{\"error\":\"Route not foud\"}");
        }

    }

}
