package tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tracker.db.repository.ProjectRepository;
import tracker.db.repository.UserRepository;
import tracker.model.dto.CreateUserDto;
import tracker.model.dto.LightUserDto;
import tracker.model.mapper.UserMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final UserMapper userMapper;

    // todo change exceptions

    public LightUserDto getUserById(UUID userId) {
        return userMapper.fromEntity(userRepository.findById((userId)).orElseThrow(() -> new NoSuchElementException("User not found")));// todo change exception
    }

    public LightUserDto createUser(CreateUserDto dto) throws Exception {
        if (userRepository.findByLogin(dto.getLogin()).isEmpty()) {
            return userMapper.fromEntity(userRepository.save(userMapper.fromDto(dto)));
        } else throw new Exception("");
    }

    public boolean assignProjectToUser(UUID userId, UUID projectId) throws Exception {
        var user = userRepository.findById(userId).orElseThrow(() -> new Exception(""));
        var project = projectRepository.findById(projectId).orElseThrow(() -> new Exception(""));
        var assignedProjects = user.getAssignedProjects();
        if (assignedProjects.isEmpty()) {
            assignedProjects = List.of(project);
        } else {
            assignedProjects.add(project);
        }
        user.setAssignedProjects(assignedProjects);
        userRepository.save(user);
        return userRepository.findById(userId).get().getAssignedProjects().equals(assignedProjects);
    }
}
