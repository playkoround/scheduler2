package com.sparta.scheduler.repository;

import com.sparta.scheduler.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public class ScheduleRepository implements JpaRepository<Schedule, long> {
}
