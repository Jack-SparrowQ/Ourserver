package model;

import java.security.Timestamp;

public class Post {
    
    private int id;
    private int authorId;
    private String description;
    private byte[] image;
    private Timestamp createdAt;

    public Post() {}

    public Post(int authorId, String description, byte[] image) {
        setAuthorId(authorId);
        setDescription(description);
        setImage(image);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

}
