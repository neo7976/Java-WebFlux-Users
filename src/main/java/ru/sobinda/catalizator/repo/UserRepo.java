package ru.sobinda.catalizator.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.User;

public interface UserRepo extends ReactiveCrudRepository<User, Long> {

    Flux<User> findByNameContainingIgnoreCase(String name);

    @Query(value = "SELECT u.id , u.name, u.telephone_number FROM Teams t JOIN TeamMembers tm ON t.id = tm.team_id JOIN users u ON u.id = tm.user_id WHERE t.id = :teamId;")
    Flux<User> findAllUsersByTeamId(@Param("teamId") Long teamId);
}
