package tracker.model.mapper;

import org.mapstruct.Mapper;
import tracker.db.entity.UserEntity;
import tracker.model.dto.LightUserDto;

@Mapper(componentModel = "spring")
public interface TimeIntervalMapper {
    ShallowTimeIntervalDto fromEntity(TimeIntervalEntity entity);

    TimeIntervalEntity fromDto(ShallowTimeIntervalDto dto);
}
