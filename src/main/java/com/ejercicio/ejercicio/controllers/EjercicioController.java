package com.ejercicio.ejercicio.controllers;

import com.ejercicio.ejercicio.dao.ejercicioDao;
import com.ejercicio.ejercicio.models.Ejercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EjercicioController {

    @Autowired
    private ejercicioDao ejercicioDao;

    @RequestMapping(value = "api/ejercicios", method = RequestMethod.GET)
    public List<Ejercicio> getEjercicios(){

       return  ejercicioDao.getEjercicio();
    }
    @RequestMapping(value = "api/ejercicios/{id}", method = RequestMethod.DELETE)
    public void  eliminar(@PathVariable Long id){
        ejercicioDao.eliminar(id);
    }
    @RequestMapping(value = "api/ejercicios")
    public void registrarEjercicios(@RequestBody Ejercicio ejercicio){
      //  return  ejercicioDao.registar(ejercicio);
    }
}
