package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;
import utils.DBConnection;

public class PostDAO {
    
    //Method for to create a new post
    public boolean createPost(Post post) {

        //SLQ instruction
        String sql = "INSERT INTO posts (author_id, description, image) VALUES (?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, post.getAuthorId());
            stmt.setString(2, post.getDescription());
            stmt.setBytes(3, post.getImage());

            return stmt.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //Method for to delete any post
    public boolean deletePost(int postId) {
        String sql = "DELETE FROM posts WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, postId);
            return stmt.executeUpdate() > 0;

        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //Method for display recent posts
    public List<Post> getRecentPosts(int limit) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts ORDER BY created_at DESC LIMIT ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setAuthorId(rs.getInt("author_id"));
                post.setDescription(rs.getString("description"));
                post.setImage(rs.getBytes("image"));
                post.setCreatedAt(rs.getTimestamp("created_at"));
                posts.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

}
