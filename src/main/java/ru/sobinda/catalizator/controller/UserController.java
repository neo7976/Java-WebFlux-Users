package ru.sobinda.catalizator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.User;
import ru.sobinda.catalizator.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public Flux<User> list(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "5") Long count
    ) {
        return userService.list().skip(start).take(count);
    }

    @PostMapping("/add")
    public Mono<User> add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/id/{id}")
    public Mono<User> findById(@PathVariable Long id) {
        System.out.println("Не дошли");
        return userService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Mono<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
