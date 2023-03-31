package ru.sobinda.catalizator.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.sobinda.catalizator.model.Team;

public interface TeamRepo extends ReactiveCrudRepository<Team, Long> {
}
