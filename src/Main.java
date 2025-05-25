
import service.FeedService;
import utils.ImageUtils;

public class Main {
    public static void main(String[] args) {
        FeedService auth = new FeedService();
        try {
            byte[] imagen = ImageUtils.imageToBytes("C:\\Users\\Carlo\\Downloads\\backiee-51699.jpg");
            boolean publicado = auth.publicarPost(1, "Mi primer post con imagen", imagen);

            if (publicado) {
                System.out.println("Post publicado.");
            } else {
                System.out.println("Error al publicar.");
            }

        } catch (Exception e) {
            System.out.println(" Error al cargar la imagen: " + e.getMessage());
        }
    }
}
