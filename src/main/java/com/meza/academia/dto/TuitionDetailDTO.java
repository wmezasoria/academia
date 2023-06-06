package com.meza.academia.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TuitionDetailDTO {

    private Integer id;
    @NotNull
    @NotEmpty
    private CourseDTO curso;
    @NotNull
    @NotEmpty
    private TuitionDTO tuition;
    @NotNull
    @NotEmpty
    private String classroom;
}
