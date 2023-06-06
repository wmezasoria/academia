package com.meza.academia.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String apellido;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10)
    private String cedula;
    @Min(value = 1)
    @Max(value = 99)
    private int edad;
}
