package http;

import java.io.IOException;

import controller.AuthController;
//Aqui se define la logica para cada ruta, y
//delega,ps al controlador
public class Router {
    //Paths
    private static final String PATH_ROOT = "/";
    private static final String PATH_REGISTER = "/register";
    private static final String PATH_LOGIN = "/login";

    //Methods
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    //Establecer el metodo Router para comunicar
    //con HttpRequest y HttpResponse
    public static void route(HttpRequest request, HttpResponse response) throws IOException {


        String method = request.getMethod();
        String path = request.getPath();

        if (METHOD_GET.equals(method)) {
            switch (path) {
                case PATH_ROOT:
                     response.setStatus(200);
                    response.sendJson("{\"message\":\"Server is ready\"}");
                    break;
                case PATH_REGISTER:
                    response.setStatus(200);
                    response.sendJson("{\"info\":\"Usa POST para registrar un usuario.\"}");
                    break;
                default:
                    sendNotFound(response);
            }
        } else if (METHOD_POST.equals(method)) {
            switch (path) {
                case PATH_REGISTER:
                    AuthController.register(request, response);
                    break;
                case PATH_LOGIN:
                    AuthController.login(request, response);
                    break;
            
                default:
                    sendNotFound(response);
            }
        } else {
            sendNotFound(response);
        }

    }

    private static void sendNotFound(HttpResponse response) throws IOException {
        response.setStatus(404);
        response.sendJson("{\"error\":\"Route not found\"}");
    }

}
