package com.meza.academia.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TuitionDTO {

    private Long id;
    @NotNull
    @NotEmpty
    private StudentDTO estudiante;
    @NotNull
    @NotEmpty
    private List<TuitionDetailDTO> detail;
    @NotNull
    @NotEmpty
    private boolean estado;
    @NotNull
    @NotEmpty
    private LocalDateTime fecha;
}
