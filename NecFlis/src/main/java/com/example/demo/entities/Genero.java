package com.example.demo.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genero")

public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idg;
	@Column(name = "nombre")
private String nameG;
	@Column(name = "descripcion")
private String descriptionG;
	@Column(name = "fecha")
private String dateG;

public Long getIdg() {
		return idg;
	}
	public void setIdg(Long id) {
		this.idg = id;
	}
public String getNameG() {
	return nameG;
}
public void setNameG(String nameG) {
	this.nameG = nameG;
}
public String getDescriptionG() {
	return descriptionG;
}
public void setDescriptionG(String descriptionG) {
	this.descriptionG = descriptionG;
}
public String getDateG() {
	return dateG;
}
public void setDateG(String dateG) {
	this.dateG = dateG;
}

}
