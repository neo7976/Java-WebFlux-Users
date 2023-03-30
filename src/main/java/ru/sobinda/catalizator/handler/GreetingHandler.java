package ru.sobinda.catalizator.handler;

import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Greeting;

import java.util.Map;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
//        BodyInserter<Greeting, ReactiveHttpOutputMessage> body =
//                BodyInserters.fromValue(new Greeting("Hello, Spring!"));

        Long start = serverRequest.queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);

        Long count = serverRequest.queryParam("count")
                .map(Long::valueOf)
                .orElse(3L);

        Flux<Greeting> data = Flux
                .just(
                        "Hello, reactive",
                        "More then one",
                        "Third post",
                        "Hello, Spring!")
                .skip(start)
                .take(count)
                .map(Greeting::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Greeting.class);
    }

    public Mono<ServerResponse> index(ServerRequest serverRequest) {
        String user = serverRequest.queryParam("user").orElse("Nobody");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .render("index", Map.of("user", user));
    }
}