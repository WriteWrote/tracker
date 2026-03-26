package tracker.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProjectToUserDto {
    private UUID userId;
    private UUID projectId;
}
