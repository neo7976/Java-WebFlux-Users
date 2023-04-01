package ru.sobinda.catalizator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Team;
import ru.sobinda.catalizator.model.User;
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


    @PostMapping("/addTeam")
    public Mono<Team> addTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @GetMapping("/id/{id}")
    public Mono<Team> findTeamById(@PathVariable Long id) {
        return teamService.findTeamById(id);
    }

    @GetMapping("/title/{title}")
    public Flux<Team> findTeamByTitle(@PathVariable String title) {
        return teamService.findTeamByTitle(title);
    }

    @GetMapping("/description/{description}")
    public Flux<Team> findTeamByDescription(@PathVariable String description) {
        return teamService.findTeamByDescription(description);
    }

    @GetMapping("/id/{id}/users")
    public Flux<User> findUsersByTeamId(@PathVariable Long id) {
        return teamService.findUsersByTeamId(id);
    }

//    @GetMapping("/add-user-for-team")
//    public Mono<Team> addUserForTeam(@RequestParam("id_user") Long idUser, @RequestParam("id_team") Long idTeam) {
//        return teamService.addUserForTeam(idUser, idTeam);
//    }


}
