package com.dallab.crossfit.interfaces;

import com.dallab.crossfit.domain.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/classrooms")
    public Stream<ClassroomDto> list() {
        var classrooms = classroomRepository.findAll();

        return classrooms.stream().map(classroom ->
                // TODO: use model mapper.
                ClassroomDto.builder()
                        .id(classroom.getId())
                        .date(classroom.getDate())
                        .startTime(classroom.getStartTime())
                        .endTime(classroom.getEndTime())
                        .personnel(classroom.getPersonnel())
                        .build()
        );
    }

}
