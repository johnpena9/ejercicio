package com.ejercicio.ejercicio.dao;

import com.ejercicio.ejercicio.models.Ejercicio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ejercicioDaoimp implements ejercicioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ejercicio> getEjercicio() {
        String query= "FROM Ejercicio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {

        Ejercicio ejercicio= entityManager.find(Ejercicio.class,id);
        entityManager.remove(ejercicio);

    }

    @Override
    public void registar(Ejercicio ejercicio) {
        entityManager.merge(ejercicio);
    }

}
