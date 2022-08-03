package com.personas.Service.Implementation;

import com.personas.DaooRepo.PersonaRepository;
import com.personas.EntityOModels.Persona;
import com.personas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaSerivceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findByDNI(String dni) {
        return personaRepository.findPersonaByDni(dni);
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).get();
    }

    @Override
    public List<Persona> getAllWithFirstNumbers(String dni){
        return personaRepository.findPersonasByDniStartsWith(dni);
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

}
