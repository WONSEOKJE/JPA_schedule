package com.example.jpatest2.controller;

import com.example.jpatest2.dto.ScheduleResponse;
import com.example.jpatest2.service.ScheduleService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ScheduleControllerTest {

    private MockMvc mockMvc;
    protected MockHttpSession session;
//    @Mock
//    HttpSession session;
    @Mock
    private ScheduleService scheduleService;
    @InjectMocks
    private ScheduleController scheduleController;

    @BeforeEach
    void setUp(@Autowired ScheduleController scheduleController) {
        // MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();
        session = new MockHttpSession();
        session.setAttribute("email","test01");
    }

    @AfterEach
    public void clean(){
        session.clearAttributes(); //테스트 이후 세션 초기화
    }

    @Test
    @DisplayName("스케줄 select 테스트")
    void scheduleSelectTest() {

        ScheduleResponse response = new ScheduleResponse("8","study JPA","2023-01-10");
        List<ScheduleResponse> result = new ArrayList<>();
        result.add(response);

        given(scheduleController.scheduleList(session)).willReturn(result);

        List<ScheduleResponse> testResult = scheduleController.scheduleList(session);

        assertEquals("8",testResult.get(0).getId());
    }

    @Test
    @Transactional //이 어노테이션을 빼면 실제 실행되어 commit됨
    void controllerTest() throws Exception {
        mockMvc.perform(delete("/schedules/13")) //호출 url
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andExpect(content().string("success")) //응답이 "success"로 나와야함
                .andDo(print()); //출력
    }

    @Test
    @Transactional //이 어노테이션을 빼면 실제 실행되어 commit됨
    void scheduleMockSelectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/schedules")
                        .session(session)
                        .param("params", "example"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

}