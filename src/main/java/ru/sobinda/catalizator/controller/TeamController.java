package ru.sobinda.catalizator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Team;
import ru.sobinda.catalizator.service.TeamService;

@RequiredArgsConstructor
@RequestMapping("/team")
@RestController
public class TeamController {

    private final TeamService teamService;


    @GetMapping
    public Flux<Team> listAll(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "5") Long count) {
        return teamService.list().skip(start).take(count);
    }


    @PostMapping("/add")
    public Mono<Team> addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

}
