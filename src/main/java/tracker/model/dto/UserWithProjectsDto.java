package tracker.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserWithProjectsDto {
    private String login;
    private String grade;
    private String position;
    private List<ProjectDto> projects;
}
