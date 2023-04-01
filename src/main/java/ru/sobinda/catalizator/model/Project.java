package ru.sobinda.catalizator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    private long id;
    private String title;
//    private List<Team> team;
    private String description;
    private byte[] logo;
    @Column("creation_date")
    private Instant creationDate;
    @Column("completion_date")
    private Instant completionDate;
}
