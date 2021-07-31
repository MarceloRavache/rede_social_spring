package com.rede_social.rede_social.repository;

import com.rede_social.rede_social.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveMongoRepository<Post, String> {
}
