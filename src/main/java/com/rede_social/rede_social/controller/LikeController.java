package com.rede_social.rede_social.controller;

import com.rede_social.rede_social.model.Like;
import com.rede_social.rede_social.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    public LikeController(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }
}
