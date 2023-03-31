package ru.sobinda.catalizator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Team;
import ru.sobinda.catalizator.repo.TeamRepo;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepo teamRepo;

    public Flux<Team> list() {
        return teamRepo.findAll();
    }

    public Mono<Team> addTeam(Team team) {
        return teamRepo.save(team);
    }
}
