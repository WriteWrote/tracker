package tracker.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private String name;
    private List<LightUserDto> assignedUsers;
}
