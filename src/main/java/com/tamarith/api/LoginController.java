package com.tamarith.api;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "Ya se ha inciado la sesión");
			return "redirect:/user/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Nombre de usuario o contraseña incorrecta");
		}
		
		if(logout != null) {
			model.addAttribute("success", "Se ha cerrado la sesión");
		}
		
		return "login";
	}
}
