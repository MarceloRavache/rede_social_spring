package com.rede_social.rede_social.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Document(collation = "posts")
public class Post {
    @Id
    private String id;

    @NotBlank
    @Size(max = 255)
    private String image;

    @NotBlank
    @Size(max = 255)
    private String legend;

    @NotBlank
    @Size(max = 255)
    private String id_user;

    public Post() {
    }

    public Post(String id, String image, String legend, String id_user) {
        this.id = id;
        this.image = image;
        this.legend = legend;
        this.id_user = id_user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(image, post.image) && Objects.equals(legend, post.legend) && Objects.equals(id_user, post.id_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, legend, id_user);
    }
}
