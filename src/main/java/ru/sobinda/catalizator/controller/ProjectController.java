package ru.sobinda.catalizator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Project;
import ru.sobinda.catalizator.model.Team;
import ru.sobinda.catalizator.model.User;
import ru.sobinda.catalizator.service.ProjectService;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public Flux<Project> list(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "5") Long count) {
        return projectService.list().skip(start).take(count);
    }

    @GetMapping("/id/{id}")
    public Mono<Project> findById(@PathVariable Long id){
        return projectService.findById(id);
    }

    @GetMapping("/title/{title}")
    public Mono<Project> findByTitle(@PathVariable String title){
        return projectService.findByTitle(title);
    }

    @GetMapping("/id/{id}/teams")
    public Flux<Team> findTeamsByProjectId(@PathVariable Long id) {
        return projectService.findTeamsByProjectId(id);
    }

    @GetMapping("/description/{description}")
    public Flux<Project> findByDescription(@PathVariable String description){
        return projectService.findByDescription(description.toLowerCase());
    }
}
