package tracker.model.mapper;

import org.mapstruct.Mapper;
import tracker.db.entity.UserEntity;
import tracker.model.dto.LightUserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    LightUserDto fromEntity(UserEntity entity);

    UserEntity fromDto(LightUserDto dto);
}
