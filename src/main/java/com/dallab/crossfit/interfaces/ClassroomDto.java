package com.dallab.crossfit.interfaces;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomDto {

    private Long id;

    private String title;

    private String date;
    private String startTime;
    private String endTime;

    private Integer personnel;

}
