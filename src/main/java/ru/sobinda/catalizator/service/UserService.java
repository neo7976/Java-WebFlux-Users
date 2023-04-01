package ru.sobinda.catalizator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.User;
import ru.sobinda.catalizator.repo.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;


    public Flux<User> list() {
        return userRepo.findAll();
    }

    public Mono<User> addUser(User user) {
        return userRepo.save(user);
    }

    public Mono<User> findById(long id) {
       return userRepo.findById(id);
    }

    public Mono<User> findByName(String name) {
        return userRepo.findByNameIgnoreCase(name);
    }
}
