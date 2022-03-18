package com.dio_class.devweek.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dio_class.devweek.Entity.FaixaEtaria;
import com.dio_class.devweek.Repository.FaixaEtariaRepo;

public class FaixaEtariaController {

  private FaixaEtariaRepo frepository;

  public FaixaEtariaController(FaixaEtariaRepo frepository) {
    this.frepository = frepository;
  }

  @GetMapping("/faixaetaria")
  public ResponseEntity<?> findAllFaixaEtaria(){
      try{
         List<FaixaEtaria> lista = frepository.findAll();
         return new ResponseEntity<>(lista, HttpStatus.OK);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/faixaetaria/{id}")
  public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
      try{
          Optional<FaixaEtaria> unidOptional = frepository.findById(id);
          if (unidOptional.isPresent()){
              FaixaEtaria faixaEtariaUnid = unidOptional.get();
              return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/faixaetaria/novo")
  public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
    return frepository.save(newFaixa);
  }

  @DeleteMapping("/faixaetaria/remover/{id}")
  public void deleteFaixaEtaria(@PathVariable long id){
    frepository.deleteById(id);
  }
}
