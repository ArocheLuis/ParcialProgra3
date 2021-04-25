package com.example.demo.controls;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Genero;
import com.example.demo.repositories.GenderRepository;

@RestController
@RequestMapping(value ="/genero")
public class GenderControls {
	@Autowired
	GenderRepository repository;
	// Lista de generos
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Genero> getListaGenero(){
		Iterable<Genero> listaGenero = repository.findAll();
		return (Collection<Genero>) listaGenero;
	}
	// Buscar un genero en especifico
	@GetMapping(value = "/{idg}")
	@ResponseStatus(code = HttpStatus.OK)
	public Genero getGenero(@PathVariable(name ="idg")Long idg) {
	Optional<Genero> genero = repository.findById(idg)	;
	Genero result=null;
	if (genero.isPresent()) {
		result=genero.get();
	}
	return result;
	}
	// crear genero
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Genero createGenero(@RequestBody Genero genero) {
		Genero nuevoGenero =repository.save(genero);
		return nuevoGenero;
    }
	//borrar genero
	 @DeleteMapping(value = "{idg}")
	 @ResponseStatus(code = HttpStatus.ACCEPTED)
	 public void deleteGenero(@PathVariable(name = "idg") Long idg ) {
		repository.deleteById(idg); 
	 }
	 // actualizar genero
	 @PutMapping(value = "/{idg}")
	 @ResponseStatus(code = HttpStatus.ACCEPTED)
	 public Genero updateGenero(@PathVariable (name = "idg")Long idg, 
			 @RequestBody Genero genero) {
		Optional<Genero> oGenero = repository.findById(idg) ;
		if (oGenero.isPresent()) {
			Genero actual = oGenero.get();
			actual.setIdg(idg);
			actual.setNameG(genero.getNameG());
			actual.setDescriptionG(genero.getDescriptionG());  
			actual.setDateG(genero.getDateG());
			Genero updatedGenero = repository.save(actual);
			return updatedGenero;
		}
		return null;
	 }
}