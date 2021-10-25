package com.ejercicio.ejercicio.dao;

import com.ejercicio.ejercicio.models.Ejercicio;

import java.util.List;

public interface ejercicioDao {

    List<Ejercicio> getEjercicio();

    void eliminar(Long id);

    void registar(Ejercicio ejercicio);
}
