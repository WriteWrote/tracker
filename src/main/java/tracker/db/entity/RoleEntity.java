package tracker.db.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles", schema = "tracker")
@Entity
public class RoleEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "assignedRoles")
    private List<UserEntity> assignedUsers;
}
