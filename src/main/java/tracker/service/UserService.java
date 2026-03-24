package tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tracker.db.repository.UserRepository;
import tracker.model.dto.LightUserDto;
import tracker.model.mapper.UserMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public LightUserDto getUserById(UUID userId){
        return userMapper.fromEntity(userRepository.findUserEntityById((userId)));
    }


}
