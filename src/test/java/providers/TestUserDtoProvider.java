package providers;

import org.springframework.stereotype.Component;
import tracker.model.dto.CreateUserDto;

import java.util.UUID;

@Component
public class TestUserDtoProvider {
    private static final UUID id = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final String login = "test_login";
    private static final String password = "test_password";
    private static final String grade = "test grade";
    private static final String position = "test_position";

    //todo make a builder or a fabric
    public CreateUserDto getValidUserDto() {
        return getEmptyUserDto()
                .setLogin(login)
                .setPassword(password)
                .setGrade(grade)
                .setPosition(position)
                .setProjectId(id)
                ;
    }

    public CreateUserDto getEmptyUserDto() {
        return new CreateUserDto();
    }
}
