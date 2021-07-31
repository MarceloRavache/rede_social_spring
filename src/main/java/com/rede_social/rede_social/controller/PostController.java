package com.rede_social.rede_social.controller;

import com.rede_social.rede_social.model.Post;
import com.rede_social.rede_social.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @GetMapping
    public Flux<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Post>> getPost(@PathVariable (value = "id") String id){
        return postRepository.findById(id)
                .map(savePost -> ResponseEntity.ok(savePost))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Post> createPost(@RequestBody Post post){
        return postRepository.save(post);
    }
}
