package tracker.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tracker.common.Headers;
import tracker.model.dto.CreateUserDto;
import tracker.model.dto.LightUserDto;
import tracker.model.dto.ProjectToUserDto;
import tracker.service.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public LightUserDto createUser(@RequestBody CreateUserDto dto) throws Exception { // todo add controller advice
        return userService.createUser(dto);
    }
    //todo продумать, как создается юзер с ролями, и про приассайнивание ролей для юзера тоже

    @PostMapping("/assignProject")
    public ResponseEntity<String> assignProjectToUser(@RequestBody ProjectToUserDto dto) throws Exception {
        try {
            userService.assignProjectToUser(dto.getUserId(), dto.getProjectId());
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Project %s assigned to user %s".formatted(dto.getProjectId(), dto.getUserId()))
                    .build()
                    ;
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "User or project don't exist.")
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public LightUserDto getUserById(@Param("userId") UUID userId) {
        return userService.getUserById(userId);
    }
}
