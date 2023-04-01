package ru.sobinda.catalizator.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Project;
import ru.sobinda.catalizator.model.Team;

public interface ProjectRepo extends ReactiveCrudRepository<Project, Long> {

    Mono<Project> findByTitleEqualsIgnoreCase(String title);

    Flux<Project> findByDescriptionContainingIgnoreCase(String description);

    @Query(value = "SELECT t.id, t.title, t.description, t.creation_date, t.total_users FROM project p JOIN projectMembers pm ON p.id = pm.project_id JOIN teams t ON t.id = pm.team_id WHERE p.id = :team_id;")
    Flux<Team> findTeamsByProjectId(@Param("team_id") Long id);
}
