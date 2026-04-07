package tracker.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tracker.db.entity.ProjectEntity;
import tracker.model.dto.ProjectDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper {
    ProjectDto fromEntity(ProjectEntity entity);

    ProjectEntity fromDto(ProjectDto dto);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "assignedUsers", source = "dto.assignedUsers")
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "timeIntervals", source = "entity.timeIntervals")
    ProjectEntity merge(ProjectDto dto, ProjectEntity entity);
}
