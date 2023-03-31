package ru.sobinda.catalizator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("Teams")
public class Team {

    @Id
    private long id;
    private String title;
    private String depiction;
    private byte[] logo;

//    private List<User> user;
}
