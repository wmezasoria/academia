package com.meza.academia.model;


import jakarta.persistence.*;
import lombok.*;

/**
 *
 */
@Entity
@Table(name = "student")
//@ToString(exclude = "edad")
//@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 50)
    @ToString.Include
    private String nombre;

    @Column(nullable = false, length = 50)
    @ToString.Include
    private String apellido;

    @Column(nullable = false, length = 10, unique = true)
    @ToString.Include
    private String dni;

    @Column(nullable = false)
    @ToString.Exclude
    private int edad;

//    @Builder
//    public static Student createSinEdad (Integer id, String nombre, String apellido, String dni) {
//        return new Student(id, nombre, apellido, dni, 0);
//    }


}
