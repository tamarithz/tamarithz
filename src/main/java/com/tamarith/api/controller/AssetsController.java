package com.tamarith.api.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tamarith.api.model.entity.ActivosTipo;
import com.tamarith.api.model.service.AssetService;

@Controller
@SessionAttributes("assets")
public class AssetsController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AssetService assetService;
	
	@Secured("ROLE_USER")
	@RequestMapping(value = {"/listar", "/"}, method = RequestMethod.GET)
	public String listar(Model model, Authentication authentication, HttpServletRequest request) {

		if(authentication != null) {
			logger.info("Bienvenido: ".concat(authentication.getName()));
		}
		List<ActivosTipo> assets = assetService.getActivosTipo();
		model.addAttribute("assets", assets);
		return "listar";
	}
	
}
