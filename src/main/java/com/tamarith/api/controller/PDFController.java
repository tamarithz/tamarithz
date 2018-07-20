package com.tamarith.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class PDFController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Aquí se gestina la inserción de datos en la vista/modelo para luego gestionarlo con la vista pdf
		//com.tamarithz.api.view.PDFView;
		return null;
	}	
}
