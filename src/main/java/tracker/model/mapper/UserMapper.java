package tracker.model.mapper;

import org.mapstruct.Mapper;
import tracker.db.entity.UserEntity;
import tracker.model.dto.LightUserDto;
import tracker.model.dto.UserWithProjectsDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    LightUserDto fromEntity(UserEntity entity);

    UserWithProjectsDto fromEntityWithProjects(UserEntity entity);

    UserEntity fromDto(LightUserDto dto);
}
