package com.rede_social.rede_social.controller;

import com.rede_social.rede_social.model.User;
import com.rede_social.rede_social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public Flux<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUser (@PathVariable (value = "id") String id){
        return userRepository.findById(id)
                .map(saveUser -> ResponseEntity.ok(saveUser))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUser (@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<User>> updateUser (@PathVariable (value = "id") String id, @RequestBody User user){
        return userRepository.findById(id)
                .flatMap(existUser -> {
                    existUser.setEmail(user.getEmail());
                    return userRepository.save(existUser);
                }).map(updateUserUnit -> new ResponseEntity<>(updateUserUnit, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteUser (@PathVariable (value = "id") String id){
        return userRepository.findById(id)
                .flatMap(existUser ->
                    userRepository.delete(existUser)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
