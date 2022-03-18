package com.dio_class.devweek.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.Entity.Incidencia;
import com.dio_class.devweek.Repository.IncidenciaRepo;

@RestController
@RequestMapping("/api")
public class IncidenciaController {

  private final IncidenciaRepo inRepository;

  public IncidenciaController(IncidenciaRepo inRepository) {
    this.inRepository = inRepository;
  }

  @GetMapping("/incidencias")
  public ResponseEntity<List<Incidencia>> findIncidencia(){
    List<Incidencia> listaIncidencia = inRepository.findAll();
    if (listaIncidencia.isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
  }

  @GetMapping("/incidencia/{id}")
  public ResponseEntity<Incidencia> findIncidenciasById(@PathVariable Long id){
    Optional<Incidencia> incidenciaOptional = inRepository.findById(id);
    if (incidenciaOptional.isPresent()){
      Incidencia incidenciaUnid = incidenciaOptional.get();
      return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/incidencia/novo")
  public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia){
    return inRepository.save(newIncidencia);
  }

}
