package tracker.model.mapper;

import org.mapstruct.Mapper;
import tracker.db.entity.UserEntity;
import tracker.model.dto.LightUserDto;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto fromEntity(ProjectEntity entity);

    ProjectEntity fromDto(ProjectDto dto);
}
