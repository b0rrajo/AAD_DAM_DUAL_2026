package com.carballeira.jdbc;

import java.io.Serializable;

public class Alumno3 implements Serializable {
private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombre;
	private String apellidos;
	private int nota;
	
	
	public Alumno3(String dni, String nombre, String apellidos, int nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nota = nota;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}

	
	public String getApellidos() {
		return apellidos;
	}


	public int getNota() {
		return nota;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}
	
	 @Override
	 public boolean equals(Object obj) {
		 if (this == obj) return true;
	     if (obj == null || getClass() != obj.getClass()) return false;
	     Alumno3 otro = (Alumno3) obj;
	     return this.dni != null && this.dni.equals(otro.dni);
	 }

	 @Override
	 public int hashCode() {
		 return dni != null ? dni.hashCode() : 0;
	 }

	@Override
	public String toString() {
		String linea = String.format("%-10s %-10s %-20s %-6s\n", dni, nombre, apellidos, nota);
		return linea;
	}
	
	
}
