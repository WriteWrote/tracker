package tracker.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tracker.db.entity.ProjectEntity;
import tracker.model.dto.ProjectDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper {
    ProjectDto fromEntity(ProjectEntity entity);

    ProjectEntity fromDto(ProjectDto dto);
}
