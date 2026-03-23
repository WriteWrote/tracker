package tracker.db.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
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
    private List<RoleEntity> assignedRoles;
}
