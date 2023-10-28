package com.wsr.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsr.springboot.web.app.models.Usuario;



@Controller
@RequestMapping("/app")
public class IndexController {
	//La anotación indica la ruta de acceso al recurso solicitado en la petición
	//@RequestMapping(value="index", method=RequestMethod.GET)
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {//Model es una interfaz que permite enviar la vista tipo map clave valor
		
		model.addAttribute("titulo","Bienvenido Spring Framework");		
		return "index";
	}
	
	//creando controlador para vista perfil
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("William");
		usuario.setApellido("Sandoval");
		usuario.setEmail("wsandoval@gmail.com");
		model.addAttribute("titulo",usuario.getNombre()+" "+usuario.getApellido());
		model.addAttribute("perfil",usuario.getNombre().concat(" "+usuario.getApellido()));
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	/*
	 * @RequestMapping("/listarUsuarios") public String listar(Model model) {
	 * 
	 * List<Usuario> listaUsuarios = new ArrayList(); listaUsuarios.add(new
	 * Usuario("William","Sandoval","wsandoval@gmail.com")); listaUsuarios.add(new
	 * Usuario("Diana","Olaya","dyOlaya@gmail.com")); listaUsuarios.add(new
	 * Usuario("Esteban","Sandoval","wesandoval@gmail.com")); listaUsuarios.add(new
	 * Usuario("Samanta","Sandoval","karitosandoval@gmail.com"));
	 * model.addAttribute("titulo","Listado de Usuarios");
	 * model.addAttribute("usuarios",listaUsuarios); return "/listarUsuarios"; }
	 */
	
	@RequestMapping("/listarUsuarios")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de Usuarios");
		return "/listarUsuarios";		
	}
	
	
	
	//enviando datos a la vista con la anotación @ModelAttribute
	
	@ModelAttribute("usuarios")
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("William","Sandoval","wsandoval@gmail.com"),
				new Usuario("Diana","Olaya","dyOlaya@gmail.com"),
				new Usuario("Esteban","Sandoval","wesandoval@gmail.com"),
				new Usuario("Samanta","Sandoval","karitosandoval@gmail.com"));
		return usuarios;
	}
	
	

}
