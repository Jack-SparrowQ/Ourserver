package dao;

import model.Post;

public class PostDAO {
    
    public boolean createPost(Post post) {

        String sql = "INSERT INTO posts (author_id, description, image) VALUES (?, ?, ?)";

    }

}
