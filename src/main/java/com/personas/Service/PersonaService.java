package com.personas.Service;

import com.personas.EntityOModels.Persona;

import java.util.List;

public interface PersonaService {


    public List<Persona> getAll();
    public Persona findByDNI(String dni);
    public Persona findById(Long id);

    public Persona save(Persona persona);
    public void deleteById(Long id);

    public List<Persona> getAllWithFirstNumbers(String dni);

}
