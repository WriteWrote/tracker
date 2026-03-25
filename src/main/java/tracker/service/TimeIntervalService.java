package tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tracker.db.repository.TimeIntervalRepository;
import tracker.model.dto.ShallowTimeIntervalDto;
import tracker.model.mapper.TimeIntervalMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TimeIntervalService {
    private TimeIntervalRepository timeIntervalRepository;
    private TimeIntervalMapper timeIntervalMapper;

    public ShallowTimeIntervalDto addTimeInterval(ShallowTimeIntervalDto dto) {
        // todo make proper move from shallow dto to entity
        return timeIntervalMapper.fromEntity(timeIntervalRepository.save(timeIntervalMapper.fromDto(dto)));
    }

    public void deleteTimeInterval(UUID timeIntervalId) {
        if (timeIntervalRepository.findById(timeIntervalId).isPresent()) {
            timeIntervalRepository.deleteById(timeIntervalId);
        }
    }
}
