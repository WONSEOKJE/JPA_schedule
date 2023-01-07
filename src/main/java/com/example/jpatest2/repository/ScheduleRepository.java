package com.example.jpatest2.repository;

import com.example.jpatest2.entity.Schedule;
import com.example.jpatest2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByUser(User user);

}
