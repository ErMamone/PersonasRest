package com.personas.Controller;

import com.personas.EntityOModels.Persona;
import com.personas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity<?> getAllPersonas(){
        List<Persona> personas;
        try {
            personas = personaService.getAll();
        } catch (Exception e) {
            System.out.println("Error FindAll: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/personaDni{dni}")
    public ResponseEntity<?> getPersonaDni(@RequestParam String dni){
        Persona personas;
        try {
            personas = personaService.findByDNI(dni);
        } catch (Exception e) {
            System.out.println("Error find: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/personaId{id}")
    public ResponseEntity<?> getPersonaId(@RequestParam Long id){
        Persona personas;
        try {
            personas = personaService.findById(id);
        } catch (Exception e) {
            System.out.println("Error find: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/personasPorDni{dniInicio}")
    public ResponseEntity<?> getPersonasConElInicioEn(@RequestParam String dniInicio){
        List<Persona> personas;
        try {
            personas = personaService.getAllWithFirstNumbers(dniInicio);
        } catch (Exception e) {
            System.out.println("Error getFirstNumbers: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePersona(@RequestBody Persona personaDTO){
        Persona persona = null;
        try {
            if (personaDTO.getDni() != null) {
                persona = personaService.save(personaDTO);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error save: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping("/modifyPersona")
    public ResponseEntity<?> modificarPersona(@RequestBody Persona personaDTO){
        Persona persona = null;
        try {
            if (personaService.findById(personaDTO.getId()).equals(null)){
                throw new Exception();
            }else {
                if (personaDTO.getDni() != null) {
                    persona = personaService.save(personaDTO);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Error updating: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping("/borrarPersonaId{id}")
    public ResponseEntity<?> borrarPersonaId(@RequestParam Long id){
        Persona persona = null;
        try {
            if (id != null) {
                persona = personaService.findById(id);
                personaService.deleteById(id);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error deleting: {"+e.getMessage()+"}");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Dni: "+id+" se elimino correctamente", HttpStatus.OK);
    }
}
