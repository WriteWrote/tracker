package tracker.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tracker.common.Headers;
import tracker.model.dto.ShallowTimeIntervalDto;
import tracker.service.TimeIntervalService;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/timeintervals")
public class TimeIntervalController {
    private final TimeIntervalService timeIntervalService;

    @PostMapping("/create")
    public ResponseEntity<ShallowTimeIntervalDto> createTimeInterval(@RequestBody ShallowTimeIntervalDto dto){
        try {
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Created time interval")
                    .body(timeIntervalService.addTimeInterval(dto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Time interval or user don't exist")
                    .build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTimeInterval(@RequestBody UUID timeIntervalId){
        try {
            timeIntervalService.deleteTimeInterval(timeIntervalId);
            return ResponseEntity.ok()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Deleted time interval with id= %s".formatted(timeIntervalId))
                    .build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .header(Headers.SERVER_MESSAGE.getValue(), "Time interval with this UUID doesn't exist")
                    .build();
        }
    }
}
