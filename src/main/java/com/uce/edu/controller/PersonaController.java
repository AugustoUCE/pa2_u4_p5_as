package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//http://localhost:8080/personas/buscarTodos
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		List<Persona> list= this.personaService.consultarTodos();
		model.addAttribute("personas",list);
		return "vistaListaPersonas";
	}
	
	

	// los metodos tambien debe tener parte del Path
	// path
	// get
	// http://localhost:8080/personas/buscar
	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		return "";
	}

	// http://localhost:8080/personas/actualizar
	@PutMapping("/actualizar")
	public String actualizar() {

		return "";
	}

	// http://localhost:8080/personas/borrar
	@DeleteMapping("/borrar")
	public String borrar() {

		return "";
	}

	@PostMapping("/guardar")
	public String guardar() {

		return "";
	}

}
