package http;

import java.io.IOException;
import java.time.LocalTime;

import controller.AuthController;
import controller.PostController;
//Aqui se define la logica para cada ruta, y
//delega,ps al controlador
public class Router {
    //Paths
    private static final String PATH_ROOT = "/";
    private static final String PATH_REGISTER = "/register";
    private static final String PATH_REGISTER_POST = "/register/post";
    private static final String PATH_LOGIN = "/login";
    private static final String PATH_POSTS = "/posts";

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
                    System.out.println("Someone has used "+PATH_ROOT);

                    break;
                case PATH_REGISTER:
                    response.setStatus(200);
                    response.sendJson("{\"info\":\"Usa POST para registrar un usuario.\"}");
                    System.out.println("Someone has used "+PATH_REGISTER);

                    break;
                case PATH_LOGIN:
                    response.setStatus(200);
                    response.sendJson("{\"info\":\"This is the /login.\"}");
                    System.out.println("Someone has used "+PATH_LOGIN);
                    break; 
                case PATH_REGISTER_POST:
                    response.setStatus(200);
                    response.sendJson("{\"info\":\"This is to upload post.\"}");
                    System.out.println("Someone has used "+PATH_REGISTER_POST);
                    break;
                default:
                    sendNotFound(response);
            }
        } else if (METHOD_POST.equals(method)) {
            switch (path) {
                case PATH_REGISTER:
                    System.out.println(LocalTime.now()+"Someone intenta registrarse");
                    AuthController.register(request, response);
                    break;
                case PATH_LOGIN:
                    System.out.println(LocalTime.now()+"Alguien intenta logear");
                    AuthController.login(request, response);
                    break;
                case PATH_REGISTER_POST:
                    System.out.println(LocalTime.now()+"Alguien intenta subir un post");
                    PostController.register(request, response);
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
