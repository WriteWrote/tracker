package tracker.model.dto;

import lombok.Data;

@Data
public class ProjectDto {
    private String name;
    private List<LightUserDto> assignedUsers;
}
