package service;

import dao.PostDAO;
import model.Post;

public class PostService {

    private PostDAO postDAO = new PostDAO();

    public boolean register(String tittle, String description, String price) {

        Post post = new Post(tittle, description, price);
        return postDAO.createPost(post);
    }
}
