package tracker.db.entity;

import jakarta.persistence.Entity;
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
public class TimePieces {
    @Column("id_user")
    private UUID idUser;

    @Column("id_project")
    private UUID idProject;

    @Column("time_minutes")
    private Integer timeInMin;

    @Column
    private String description;
}
