package com.example.jpatest2.controller;

import com.example.jpatest2.dto.ScheduleRequest;
import com.example.jpatest2.dto.ScheduleResponse;
import com.example.jpatest2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<ScheduleResponse> scheduleList(HttpSession session) {
        String email = String.valueOf(session.getAttribute("email"));
        return scheduleService.scheduleList(email);
    }

    @DeleteMapping("/schedules/{id}")
    public String deleteSchedule(@PathVariable("id") String id) {
        return scheduleService.deleteSchedule(id);
    }

    @PostMapping("/schedules")
    public String insertSchedule(ScheduleRequest scheduleRequest, HttpSession session) {
        scheduleRequest.setEmail(String.valueOf(session.getAttribute("email")));
        return scheduleService.insertSchedules(scheduleRequest);
    }
}
