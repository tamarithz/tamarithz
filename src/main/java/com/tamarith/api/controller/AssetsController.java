package com.tamarith.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamarith.api.model.service.AssetService;

@RestController
//@SessionAttributes("assets")
public class AssetsController {

	public String assetType;
	public String assetSubType;
	
	@Autowired
	private AssetService assetService;
	
	@GetMapping("/listar")
	//@ResponseStatus(HttpStatus.OK)
	public String listar(Model model) {
		model.addAttribute("assets", assetService.getActivosSubtipo());
		return "listar";
	}
}
