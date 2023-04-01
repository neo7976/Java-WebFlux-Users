package ru.sobinda.catalizator.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.sobinda.catalizator.model.Team;
import ru.sobinda.catalizator.model.User;
import ru.sobinda.catalizator.repo.TeamRepo;
import ru.sobinda.catalizator.repo.UserRepo;

import javax.naming.NameNotFoundException;
import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepo teamRepo;
    private final UserRepo userRepo;

    public Flux<Team> list() {
        return teamRepo.findAll();
    }

    public Mono<Team> addTeam(Team team) {
        return teamRepo.save(team);
    }

    public Mono<Team> findTeamById(long id) {
        return teamRepo.findById(id);
    }

    public Flux<Team> findTeamByTitle(String title) {
        return teamRepo.findByTitleContainingIgnoreCase(title);
    }

    public Flux<Team> findTeamByDescription(String description) {
        return teamRepo.findByDescriptionContainingIgnoreCase(description);
    }

    public Flux<User> findUsersByTeamId(Long id) {
        return userRepo.findAllUsersByTeamId(id);
    }

//    @SneakyThrows
//    @Transactional
//    public Mono<Team> addUserForTeam(Long idUser, Long idTeam) {
//        var userOptional = userRepo.findById(idUser).blockOptional();
//        if (userOptional.isEmpty())
//            throw new NameNotFoundException();
//        var teamOptional = teamRepo.findById(idTeam).blockOptional();
//        if (teamOptional.isEmpty())
//            throw new NameNotFoundException();
//
//        var user = userOptional.get();
//        var team = teamOptional.get();
//
//        team.setTotalUsers(team.getTotalUsersAndIncrement());
//        //добавить в команду
//        teamRepo.saveTeamMembers(user.getId(), team.getId());
//        return teamRepo.save(team);
//    }
}
