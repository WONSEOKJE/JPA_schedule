package com.example.jpatest2.service;

import com.example.jpatest2.dto.ScheduleRequest;
import com.example.jpatest2.dto.ScheduleResponse;

import java.util.List;

public interface ScheduleService {

    //스케줄 목록
    List<ScheduleResponse> scheduleList(String email);

    //스케줄 삭제
    String deleteSchedule(String id);

    //스케줄 등록
    String insertSchedules(ScheduleRequest scheduleRequest);
}
