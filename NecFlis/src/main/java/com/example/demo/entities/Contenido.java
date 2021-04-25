package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenido")
public class Contenido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idc;
	@Column(name = "nombre")
private String name;
	@Column(name = "resumen")
private String resume;;
	@Column(name = "categoria")
private int category;
	@Column(name = "genero")
private int gender;
@Column(name = "fecha")
private String date;
public Long getIdc() {
	return idc;
}
public void setIdc(Long idc) {
	this.idc = idc;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getResume() {
	return resume;
}
public void setResume(String resume) {
	this.resume = resume;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public int getGender() {
	return gender;
}
public void setGender(int gender) {
	this.gender = gender;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}