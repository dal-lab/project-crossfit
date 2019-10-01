package com.dallab.crossfit.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Classroom {

    @Getter
    private Long id;

    @Getter
    private String date;

    @Getter
    private String startTime;

    @Getter
    private String endTime;

    @Getter
    private Integer personnel;

}
