package ru.sobinda.catalizator.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.User;

public interface UserRepo extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByNameIgnoreCase(String name);
}
