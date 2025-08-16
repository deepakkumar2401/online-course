package com.te.online_course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String level;
    private Double price;

}
