package com.sparta.scheduler.controller;

import com.sparta.scheduler.entity.Schedule;
import com.sparta.scheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {
    private ScheduleService myScheduleService;

    public ScheduleController(ScheduleService appScheduleService) {
        myScheduleService = appScheduleService;
    }


    @PostMapping("/schedules")
    public ResponseEntity<Schedule> createSchedule(@RequestBody String title, @RequestBody String content){
        Schedule createdSchedule = myScheduleService.createSchedule(title, content);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id) {
        Schedule foundSchedule = myScheduleService.getSchedule(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundSchedule);
    }


    // @PathVariable -> https://localhost:8080/schedules/42
    // @RequestBody -> JSON { 'title' : 'fgewrerwrw', 'content' : "fewfgew" }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<Schedule> editSchedule(@PathVariable Long id, @RequestBody String title, @RequestBody String content){
        Schedule editedSchedule = myScheduleService.editSchedule(id, title, content);
        return ResponseEntity.status(HttpStatus.OK).body(editedSchedule);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        if (myScheduleService.deleteSchedule(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
