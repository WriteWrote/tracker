package tracker.db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects", schema = "tracker")
@Entity
public class ProjectEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "tracker",
            name = "user_projects",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private Set<UserEntity> assignedUsers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(table = "time_pieces", name = "id_project")
    private List<TimePiecesEntity> timePieces;
}
