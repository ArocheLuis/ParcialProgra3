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

import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoryRepository;

@RestController
@RequestMapping(value ="/categorias")
public class CategoryControls {
	@Autowired
	CategoryRepository repository;
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	//Lista de categorias
	public Collection<Categoria> getListaCategoria(){
		Iterable<Categoria> listaCategorias = repository.findAll();
		return (Collection<Categoria>) listaCategorias;
	}
	//buscar por un id (categoria en especifico)
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria getCategoria(@PathVariable(name ="id")Long id) {
	Optional<Categoria> categoria = repository.findById(id)	;
	Categoria result=null;
	if (categoria.isPresent()) {
		result=categoria.get();
	}
	return result;
	}
	// crear categoria
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria createCategoria(@RequestBody Categoria categoria) {
		Categoria nuevaCategoria =repository.save(categoria);
		return nuevaCategoria;	
	}
	//borrar categoria
	 @DeleteMapping(value = "{id}")
	 @ResponseStatus(code = HttpStatus.ACCEPTED)
	 public void deleteCategoria(@PathVariable(name = "id") Long id ) {
		repository.deleteById(id); 
	 }
	 // actualizar categoria
	 @PutMapping(value = "/{id}")
	 @ResponseStatus(code = HttpStatus.ACCEPTED)
	 public Categoria updateCategoria(@PathVariable (name = "id")Long id, 
			 @RequestBody Categoria categoria) {
		Optional<Categoria> oCategoria = repository.findById(id) ;
		if (oCategoria.isPresent()) {
			Categoria actual = oCategoria.get();
			actual.setId(id);
			actual.setName(categoria.getName());
			actual.setDescription(categoria.getDescription());  
			actual.setDate(categoria.getDate());
			Categoria updatedCategoria = repository.save(actual);
			return updatedCategoria;
		}
		return null;
	 }
}
