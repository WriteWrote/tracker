package tracker.db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time_intervals", schema = "tracker")
@Entity
public class TimeIntervalEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(table = "users", name = "id")
//    @Column(name = "id_user")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(table = "projects", name = "id")
//    @Column(name = "id_project")
    private ProjectEntity project;

    @Column(name = "time_minutes")
    private Integer timeInMin;

    @Column
    private String description;
}
