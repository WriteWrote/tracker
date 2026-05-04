package providers;

import org.springframework.stereotype.Component;
import tracker.model.dto.ProjectDto;

import java.util.List;
import java.util.UUID;

@Component
public class TestProjectDtoProvider {
    private static final UUID id = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final String name = "test_project";

    //todo make a builder or a fabric
    public ProjectDto getValidProjectDto() {
        return getEmptyProjectDto()
                .setName(name)
                .setAssignedUsers(List.of())
                ;
    }

    public ProjectDto getEmptyProjectDto() {
        return new ProjectDto();
    }
}
