package com.rede_social.rede_social.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collation = "likes")
public class Like {

    @Id
    private String id;

    @NotBlank
    @Size(max = 255)
    private String id_post;

    @NotBlank
    @Size(max = 255)
    private String id_user;
}
