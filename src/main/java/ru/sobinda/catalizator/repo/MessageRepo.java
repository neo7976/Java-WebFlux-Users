package ru.sobinda.catalizator.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.sobinda.catalizator.model.Message;

public interface MessageRepo extends ReactiveCrudRepository<Message, Long> {
}
