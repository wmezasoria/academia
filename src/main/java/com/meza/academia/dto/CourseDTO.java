package com.meza.academia.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer id;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombre;
}
