package ru.sobinda.catalizator.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Team;

public interface TeamRepo extends ReactiveCrudRepository<Team, Long> {
    Mono<Team> findByTitle(String title);


    @Query(value = "insert into teammembers(team_id, user_id) VALUES (:team_id, :user_id)")
    void saveTeamMembers(
            @Param("team_id") long teamId,
            @Param("user_id") long userId
    );
}
