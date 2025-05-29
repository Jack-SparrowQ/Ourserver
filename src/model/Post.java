package model;

import java.sql.Timestamp;

public class Post {
    
    private int id;
    private int authorId;
    private String tittle;
    private String description;
    private byte[] image;
    private String price;
    private Timestamp createdAt;

    public Post() {}

    public Post(int authorId, String description, byte[] image) {
        setAuthorId(authorId);
        setDescription(description);
        setImage(image);
    }

    public Post(String tittle, String description, String price) {
        setDescription(description);
        setPrece(price);
        setTittle(tittle);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTittle() { return tittle; }
    public void setTittle(String tittle) { this.tittle = tittle; }
    
    public String getPrice() { return price; }
    public void setPrece(String price) { this.price = price; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

}
