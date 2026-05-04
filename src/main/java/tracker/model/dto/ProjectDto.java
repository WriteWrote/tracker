package tracker.model.dto;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class ProjectDto {
    private String name;
    @Nullable
    private List<LightUserDto> assignedUsers;

    public ProjectDto setName(String name) {
        this.name = name;
        return this;
    }

    public ProjectDto setAssignedUsers(@Nullable List<LightUserDto> assignedUsers) {
        this.assignedUsers = assignedUsers;
        return this;
    }
}
