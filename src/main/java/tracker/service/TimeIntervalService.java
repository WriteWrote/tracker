package tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tracker.db.repository.TimeIntervalRepository;

@Service
@AllArgsConstructor
public class TimeIntervalService {
    private TimeIntervalRepository timeIntervalRepository;


}
