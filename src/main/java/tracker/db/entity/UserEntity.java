package tracker.db.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "users", schema = "tracker")
@Entity
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String grade;

    @Column
    private String position;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "tracker",
            name = "user_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<RoleEntity> assignedRoles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "tracker",
            name = "user_projects",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_project")
    )
    private Set<ProjectEntity> assignedProjects;

    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(table = "time_pieces", name = "id_user")
    private List<TimeIntervalEntity> timeIntervals;
}
