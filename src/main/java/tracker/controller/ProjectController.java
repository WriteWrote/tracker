package tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tracker.common.Headers;
import tracker.model.dto.ProjectDto;
import tracker.service.ProjectService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto dto) throws Exception {
        return ResponseEntity.ok()
                .header(Headers.SERVER_MESSAGE.getValue(), "Created project")
                .body(projectService.createProject(dto));
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@RequestBody UUID projectId) {
        try {
            projectService.deleteProject(projectId);
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Created project")
                    .build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Project with this UUID doesn't exist")
                    .build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto dto) {
        try {
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Created project")
                    .body(projectService.updateProject(dto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Project with this name already exists")
                    .build();
        }
    }
}
