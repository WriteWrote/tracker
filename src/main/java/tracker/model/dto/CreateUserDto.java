package tracker.model.dto;

import jakarta.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
public class CreateUserDto {
    private String login;
    private String password;
    private String grade;
    private String position;
    @Nullable
    private UUID projectId;

    public CreateUserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public CreateUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public CreateUserDto setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public CreateUserDto setPosition(String position) {
        this.position = position;
        return this;
    }

    public CreateUserDto setProjectId(UUID projectId) {
        this.projectId = projectId;
        return this;
    }
}
