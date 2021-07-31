package com.rede_social.rede_social.controller;

import com.rede_social.rede_social.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
}
