package com.dallab.crossfit.interfaces;

import com.dallab.crossfit.domain.Classroom;
import com.dallab.crossfit.domain.ClassroomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClassroomController.class)
public class ClassroomControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClassroomRepository classroomRepostory;

    @Test
    public void list() throws Exception {
        // Given

        var classroom = Classroom.builder()
                .startTime("13:00")
                .endTime("14:00")
                .personnel(12)
                .build();

        var classrooms = new ArrayList();
        classrooms.add(classroom);

        given(classroomRepostory.findAll()).willReturn(classrooms);

        // When

        var resultActions = mvc.perform(get("/classrooms"));

        // Then

        resultActions.andExpect(status().isOk());

        String content = resultActions.andReturn().getResponse()
                .getContentAsString();
        assertThat(content)
                .contains("[{\"id\":")
                .contains("\"personnel\":12")
                .contains("\"startTime\":\"13:00\"")
                .contains("\"endTime\":\"14:00\"");
    }

}
