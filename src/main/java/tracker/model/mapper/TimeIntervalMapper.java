package tracker.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tracker.db.entity.TimeIntervalEntity;
import tracker.model.dto.ShallowTimeIntervalDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TimeIntervalMapper {
//    @Mapping(target = "idUser", source = "entity.user.id")
    ShallowTimeIntervalDto fromEntity(TimeIntervalEntity entity);

    TimeIntervalEntity fromDto(ShallowTimeIntervalDto dto);
}
