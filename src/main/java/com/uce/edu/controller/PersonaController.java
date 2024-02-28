package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.repository.service.IPersonaService;

//URL
//http://localhost:8080/personas
@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	// http://localhost:8080/personas/buscarTodos
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		List<Persona> list = this.personaService.consultarTodos();
		model.addAttribute("personas", list);
		return "vistaListaPersonas";
	}

	@GetMapping("/buscarPorId/{idPersona}")
	public String buscarPorId(@PathVariable("idPersona") Integer id, Model modelo) {
		Persona persona = this.personaService.buscarPorId(id);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
	}

	// los metodos tambien debe tener parte del Path
	// path
	// get
	// http://localhost:8080/personas/buscarPorCedula
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model modelo) {
		Persona persona = this.personaService.buscarPorCedula(cedula);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
	}

	// http://localhost:8080/personas/actualizar
	// cuando viaja el modelo en el request tengo que declarar el objeto que viaja
	@PutMapping("/actualizarPorId/{idPersona}")
	public String actualizarPorId(@PathVariable("idPersona") Integer id, Persona persona) {
		persona.setId(id);
		Persona perAux = this.personaService.buscarPorId(id);
		perAux.setApellido(persona.getApellido());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());

		this.personaService.actualizar(perAux);

		return "redirect:/personas/buscarTodos";
	}

	// actualizar por cedula
	@PutMapping("/actualizarPorCedula/{cedulaPersona}")
	public String actualizarPorId(@PathVariable("cedulaPersona") String cedula, Persona persona) {
		persona.setCedula(cedula);
		
		Persona perAux=this.personaService.buscarPorCedula(cedula);
		perAux.setApellido(persona.getApellido());
		perAux.setNombre(persona.getNombre());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());
		this.personaService.actualizar(perAux);

		return "redirect:/personas/buscarTodos";
	}



	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		this.personaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}
	@GetMapping("/nuevaPersona")
	public String mostrarNuevoPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "vistaNuevaPersona";
	}
	
	// http://localhost:8080/personas/borrar
	@DeleteMapping("/borrar/{cedulaPersona}")
	public String borrar( @PathVariable("cedulaPersona") String cedula) {
		this.personaService.eliminarPorCedula(cedula);
		return "redirect:/personas/buscarTodos";
	}
}
