package com.personas.DaooRepo;

import com.personas.EntityOModels.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    public Persona findPersonaByDni(String dni);

    public List<Persona> findPersonasByDniStartsWith(String dni);

}
