package tracker.model.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserDto {
    private String login;
    private String password;
    private String grade;
    private String position;
    @Nullable
    private UUID projectId;
}
