package com.ejercicio.ejercicio.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ejercicios")
public class Ejercicio {

    @Getter @Setter @Column(name = "nombreEjercicio")
    private String nombreEjercicio;
    @Getter @Setter @Column(name = "tipoMusculo")
    private String tipoMusculo;
    @Getter @Setter @Column(name = "series")
    private String series;
    @Getter @Setter @Column(name = "descripcion")
    private String descripcion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;




}
