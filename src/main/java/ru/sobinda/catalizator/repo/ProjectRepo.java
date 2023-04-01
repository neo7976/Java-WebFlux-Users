package ru.sobinda.catalizator.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Project;

public interface ProjectRepo extends ReactiveCrudRepository<Project, Long> {

    Mono<Project> findByTitleEqualsIgnoreCase(String title);

    Flux<Project> findByDescriptionContainingIgnoreCase(String description);
}
