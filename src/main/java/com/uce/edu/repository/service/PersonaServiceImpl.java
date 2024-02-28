package com.uce.edu.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPersonaRepository;
import com.uce.edu.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaRepository personaRepository;

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.actualizar(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		this.personaRepository.eliminarPorCedula(cedula);
	}

	@Override
	public List<Persona> consultarTodos() {
		// TODO Auto-generated method stub
		return this.personaRepository.consultarTodos();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarPorId(id);
	}

}
