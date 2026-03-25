package tracker.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tracker.db.entity.UserEntity;
import tracker.model.dto.CreateUserDto;
import tracker.model.dto.LightUserDto;
import tracker.model.dto.UserWithProjectsDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    LightUserDto fromEntity(UserEntity entity);

    UserWithProjectsDto fromEntityWithProjects(UserEntity entity);

    UserEntity fromDto(CreateUserDto dto);
}
