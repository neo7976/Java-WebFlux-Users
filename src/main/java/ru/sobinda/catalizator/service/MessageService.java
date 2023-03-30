package ru.sobinda.catalizator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Message;
import ru.sobinda.catalizator.repo.MessageRepo;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;

    public Flux<Message> list() {
        return messageRepo.findAll();
    }

    public Mono<Message> addOne(Message message) {
        return messageRepo.save(message);
    }

}
