package com.example.jpatest2.dto;

import com.example.jpatest2.entity.Schedule;
import com.example.jpatest2.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleRequest {

    private String email; //등록자
    private String title; //스케줄 제목
    private String date; //스케줄일자

    public Schedule toEntity() {
        return Schedule.builder()
                .user(User.builder().email(email).build())
                .title(title)
                .date(date)
                .build();
    }

}
