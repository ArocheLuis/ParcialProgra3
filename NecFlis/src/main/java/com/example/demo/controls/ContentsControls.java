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


import com.example.demo.entities.Contenido;
import com.example.demo.repositories.ContentsRepository;

@RestController
@RequestMapping(value ="/contenido")
public class ContentsControls {
	@Autowired
	ContentsRepository repository;
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	//Lista de contenido
	public Collection<Contenido> getListaContenido(){
		Iterable<Contenido> listaContenido = repository.findAll();
		return (Collection<Contenido>) listaContenido;
	}
	//mostrar un contenido en especifico
	@GetMapping(value = "/{idc}")
	@ResponseStatus(code = HttpStatus.OK)
	public Contenido getContenido(@PathVariable(name ="idc")Long idc) {
	Optional<Contenido> contenido = repository.findById(idc)	;
	Contenido result=null;
	if (contenido.isPresent()) {
		result=contenido.get();
	}
	return result;
	}
	// registrar contenido
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Contenido createCategoria(@RequestBody Contenido contenido) {
		Contenido registraContenido =repository.save(contenido);
		return registraContenido;	
	}
	//borrar contenido
		 @DeleteMapping(value = "{idc}")
		 @ResponseStatus(code = HttpStatus.ACCEPTED)
		 public void deleteContenido(@PathVariable(name = "idc") Long idc ) {
			repository.deleteById(idc); 
		 }
	
		 // actualizar contenido
		 @PutMapping(value = "/{idc}")
		 @ResponseStatus(code = HttpStatus.ACCEPTED)
		 public Contenido updateContenido(@PathVariable (name = "idc")Long idc, 
				 @RequestBody Contenido contenido) {
			Optional<Contenido> oContenido = repository.findById(idc) ;
			if (oContenido.isPresent()) {
				Contenido actual = oContenido.get();
				actual.setIdc(idc);
				actual.setName(contenido.getName());
				actual.setResume(contenido.getResume());  
				actual.setCategory(contenido.getCategory());
				actual.setGender(contenido.getGender());
				actual.setDate(contenido.getDate());
				Contenido updatedContenido = repository.save(actual);
				return updatedContenido;
			}
			return null;
		 }
}
