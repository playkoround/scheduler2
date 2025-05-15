package com.sparta.scheduler.service;

import com.sparta.scheduler.entity.Schedule;
import com.sparta.scheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private ScheduleRepository myScheduleRepository;

    public ScheduleService(ScheduleRepository appScheduleRepository) {
        myScheduleRepository = appScheduleRepository;
    }

    // Create Schedule
    public Schedule createSchedule(String title, String content) {
    Schedule createdSchedule = new Schedule();
        createdSchedule.setTitle(title);
        createdSchedule.setContent(content);
        createdSchedule = myScheduleRepository.save(createdSchedule);
    return createdSchedule;
    }

    // Get Schedule
    public Schedule getSchedule(Long id) {
        Schedule foundSchedule = myScheduleRepository.findById(id).orElseThrow();
        return foundSchedule;
    }

    // Edit Schedule
    public Schedule editSchedule(Long id, String title, String content) {
        Schedule editedSchedule = myScheduleRepository.findById(id).orElseThrow();
        editedSchedule.setTitle(title);
        editedSchedule.setContent(content);
        editedSchedule = myScheduleRepository.save(editedSchedule);
        return editedSchedule;
    }

    // Delete Schedule
    public boolean deleteSchedule(Long id){
        if(myScheduleRepository.existsById(id)) {
            myScheduleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
