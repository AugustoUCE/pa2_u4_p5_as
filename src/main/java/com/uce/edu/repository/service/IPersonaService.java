package com.uce.edu.repository.service;

import java.util.List;

import com.uce.edu.repository.modelo.Persona;

public interface IPersonaService {
	
	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public Persona buscarPorCedula(String cedula);
	
	public Persona buscarPorId(Integer id);

	public void eliminarPorCedula(String cedula);
	
	public List<Persona> consultarTodos();

}
