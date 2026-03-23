package tracker.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
    private UUID id;

    @Column
    private String name;
    // todo link to users
}
