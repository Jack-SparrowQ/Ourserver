package service;

import java.util.List;

import dao.PostDAO;
import model.Post;

public class FeedService {
    private PostDAO postDAO = new PostDAO();

    public boolean publicarPost(int authorId, String descripcion, byte[] imagen) {
        if (descripcion == null || descripcion.isEmpty()) {
            System.out.println("La descripción no puede estar vacía.");
            return false;
        }
        if (imagen == null || imagen.length == 0) {
            System.out.println("La imagen es obligatoria.");
            return false;
        }

        Post post = new Post(authorId, descripcion, imagen);
        return postDAO.createPost(post);
    }

    public List<Post> obtenerUltimosPosts(int quatity) {
        return postDAO.getRecentPosts(quatity);
    }

    public boolean eliminarPost(int postId) {
        return postDAO.deletePost(postId);
    }
}
