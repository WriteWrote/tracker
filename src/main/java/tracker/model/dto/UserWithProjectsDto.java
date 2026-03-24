package tracker.model.dto;

import lombok.Data;

@Data
public class UserWithProjectsDto {
    private String login;
    private String grade;
    private String position;
    private List<ProjectDto> projects;
}
