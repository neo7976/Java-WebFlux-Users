package ru.sobinda.catalizator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Project;
import ru.sobinda.catalizator.model.Team;
import ru.sobinda.catalizator.model.User;
import ru.sobinda.catalizator.repo.ProjectRepo;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepo;


    public Flux<Project> list() {
      return projectRepo.findAll();
    }

    public Mono<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    public Mono<Project> findByTitle(String title) {
        return projectRepo.findByTitleEqualsIgnoreCase(title);
    }

    public Flux<Project> findByDescription(String description) {
        return projectRepo.findByDescriptionContainingIgnoreCase(description);
    }

    public Flux<Team> findTeamsByProjectId(Long id) {
        return projectRepo.findTeamsByProjectId(id);
    }
}
