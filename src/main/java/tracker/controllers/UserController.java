package tracker.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<LightUserDto> createUser(@RequestBody CreateUserDto dto) { // todo add controller advice
        try {
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Created user")
                    .body(userService.createUser(dto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Error while creating user")
                    .build();

        }
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
    public ResponseEntity<LightUserDto> getUserById(@PathVariable @Param("userId") UUID userId) {
        try {
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Retrieved user %s".formatted(userId))
                    .body(userService.getUserById(userId));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "No such user %s".formatted(userId))
                    .build();
        }
    }
}
