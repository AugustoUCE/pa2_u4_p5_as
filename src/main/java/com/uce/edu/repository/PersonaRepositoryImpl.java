package com.uce.edu.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public Persona seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		String jpql="SELECT p FROM Persona p WHERE p.cedula =: cedula";
		TypedQuery<Persona> myQuery =this.entityManager.createQuery(jpql,Persona.class);
		myQuery.setParameter("cedula", cedula);
		
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Persona p = this.seleccionarPorCedula(cedula);
		this.entityManager.remove(p);
		//o vale hacer esto 
		//this.entityManager.remove(this.seleccionarPorCedula(cedula));
	}

	@Override
	public List<Persona> consultarTodos() {
		// TODO Auto-generated method stub
		String jpql="SELECT p FROM Persona p ";
		TypedQuery<Persona> myQuery =this.entityManager.createQuery(jpql,Persona.class);
		
		return myQuery.getResultList();
	}

	@Override
	public Persona seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

}
