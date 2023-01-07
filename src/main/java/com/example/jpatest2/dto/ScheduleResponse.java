package com.example.jpatest2.dto;

import com.example.jpatest2.entity.Schedule;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleResponse {

    private String id;
    private String title;
    private String date;

    public ScheduleResponse(Schedule schedule) {
        this.id = String.valueOf(schedule.getId());
        this.title = schedule.getTitle();
        this.date = schedule.getDate();
    }

}
