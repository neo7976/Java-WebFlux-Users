package ru.sobinda.catalizator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    private long id;
    private String title;
    private Team team;
    private String depiction;
    private byte[] logo;
    private Instant start;
    private Instant end;
}
