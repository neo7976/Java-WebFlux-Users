package ru.sobinda.catalizator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Message;
import ru.sobinda.catalizator.service.MessageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/controller")
public class MainController {
    private final MessageService messageService;

    @GetMapping
    public Flux<Message> list(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count
    ) {
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> add(@RequestBody Message message) {
        return messageService.addOne(message);
    }

}
