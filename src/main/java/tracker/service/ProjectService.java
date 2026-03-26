package tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tracker.db.repository.ProjectRepository;
import tracker.model.dto.ProjectDto;
import tracker.model.mapper.ProjectMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectDto createProject(ProjectDto dto) throws Exception {
        if (projectRepository.existsByName(dto.getName())) {
            throw new Exception("");
        } else {
            return projectMapper.fromEntity(projectRepository.save(projectMapper.fromDto(dto)));
        }
    }

    public void deleteProject(ProjectDto dto) throws Exception {
        if (!projectRepository.existsByName(dto.getName())) {
            throw new Exception("");
        } else {
            projectRepository.delete(projectMapper.fromDto(dto));
        }
    }

    public void deleteProject(UUID id) throws Exception {
        if (!projectRepository.existsById(id)) {
            throw new Exception("");
        } else {
            projectRepository.deleteById(id);
        }
    }

    public ProjectDto updateProject(ProjectDto dto) throws Exception {
        if (!projectRepository.existsByName(dto.getName())) {
            throw new Exception("");
        } else {
            // todo fix merge
            var updatedProject = projectMapper.merge(dto, projectRepository.findByName(dto.getName()));
            return projectMapper.fromEntity(projectRepository.save(updatedProject));
        }
    }
}
