package tracker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProjectToUserDto {
    private UUID userId;
    private UUID projectId;
}
