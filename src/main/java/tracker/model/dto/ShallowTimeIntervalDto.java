package tracker.model.dto;

import lombok.Data;

@Data
public class ShallowTimeIntervalDto {
    private UUID idUser;
    private UUID idProject;
    private Integer timeInMin;
    private String description;
}
