package controller;

import java.io.IOException;
import java.time.LocalTime;

import org.json.JSONObject;

import http.HttpRequest;
import http.HttpResponse;
import service.PostService;

public class PostController {
    
        public static void register(HttpRequest request, HttpResponse response) throws IOException{
        try {
            JSONObject json = new JSONObject(request.getBody());
            String tittle = json.getString("title");
            String description = json.getString("description");
            String price = json.getString("price");

            PostService service = new PostService();
            boolean success = service.register(tittle, description, price);

            if (success) {
                response.setStatus(200);
                response.sendJson("{\"message\":\"Post uploaded successfully!\"}");
                System.out.println(getTime()+"El que hizo la peticion subio su post");
            } else {
                response.setStatus(400);
                response.sendJson("{\"error\":\"Error uploading post:\"}");
                                System.out.println(getTime()+"El que hizo la peticion no pudo registrar su post");

            }


        }catch(Exception e) {
            response.setStatus(500);
            response.sendJson("{\"Error\":\"Internal error into Server\"}"+e.getMessage());
        }
    }

    public static String getTime() {
        return "["+LocalTime.now()+"]";
    }

}
