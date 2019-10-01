package com.dallab.crossfit.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassroomTest {

    @Test
    public void creation() {
        var classroom = Classroom.builder()
                .id(1004L)
                .personnel(12)
                .build();

        assertThat(classroom.getId()).isEqualTo(1004L);
        assertThat(classroom.getPersonnel()).isEqualTo(12);
    }

}