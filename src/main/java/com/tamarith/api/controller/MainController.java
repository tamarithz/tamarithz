
package com.tamarith.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	/*---Esta será una referencia a un DAO que uniremos con
	 * @Autowired
	 * private Bean beanDAO;*/
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("title", "Tamarith index");
		return "index";
	}
	
	
	
	/*Plantilla para nuevos métodos del controller:
	 * 
	 * ---SE INDICA EL TIPO DE MÉTODO.Este es genérico, se puede usar
	 * ---también @GetMapping o @PostMapping, etc... en ese caso no hace falta más
	 * ---que la url
	 * @RequestMapping(value="accion", method=RequestMethod.GET)
	 * 
	 * ---Se declara el método con un Model para comunicar con la vista
	 * public void accion(Model model){
	 * ---dentro del método se usa el model para unir la vista (un atributo HTML)
	 * ---con el modelo(un DAO declarado)
	 * model.addAttribute("atributo", beanDAO.accion();
	 * 
	 * */
}
