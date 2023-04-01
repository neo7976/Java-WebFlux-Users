package ru.sobinda.catalizator.model;

import io.r2dbc.spi.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("Teams")
public class Team {

    @Id
    private long id;
    private String title;
    private String description;
    private byte[] logo;

    @Column("creation_date")
    private Instant creationDate;

    @Column("total_users")
    private int totalUsers;
    //    private List<User> user;

    public int getTotalUsersAndIncrement() {
        return totalUsers + 1;
    }

}
