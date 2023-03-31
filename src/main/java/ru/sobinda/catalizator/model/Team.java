package ru.sobinda.catalizator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    private long id;
    private String title;
    private String depiction;
    private byte[] logo;
    private User user;
}
