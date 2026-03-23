package tracker.db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time_pieces", schema = "tracker")
@Entity
public class TimePiecesEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column("id_user")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "users", name = "id")
    private UserEntity idUser;

    @Column("id_project")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "projects", name = "id")
    private ProjectEntity idProject;

    @Column("time_minutes")
    private Integer timeInMin;

    @Column
    private String description;
}
