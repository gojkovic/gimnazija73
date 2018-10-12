package com.kp73.gimnazija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kp73.gimnazija.entities.Predmet;
import com.kp73.gimnazija.service.PredmetService;

@Controller
public class PredmetController {
	
	@Autowired
	private PredmetService predmetService;
	
	@GetMapping("/predmet")
	public ModelAndView predmet(){
		ModelAndView modelAndView = new ModelAndView();
		List<Predmet> predmetList = predmetService.getAllPredmet();
		modelAndView.addObject("predmetList", predmetList);
		modelAndView.setViewName("predmet");
		return modelAndView;
	}
	
	@GetMapping("/addPredmet")
	public ModelAndView addPredmet() {
		ModelAndView model = new ModelAndView();
		Predmet Predmet = new Predmet();
		model.addObject("predmetForm", Predmet);
		model.setViewName("predmet_form");
		return model;
	}

	@GetMapping("/editPredmet/{id}")
	public ModelAndView editPredmet(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		Predmet Predmet = predmetService.getPredmetById(id);
		model.addObject("predmetForm", Predmet);
		model.setViewName("predmet_form");

		return model;
	}

	@PostMapping("/savePredmet")
	public ModelAndView save(@ModelAttribute("predmetForm") Predmet predmet) {
		predmetService.saveOrUpdate(predmet);
		return new ModelAndView("redirect:/addPredmet");
	}

	@GetMapping("/deletePredmet/{id}")
	public ModelAndView delete(@PathVariable("id") long id) {
		predmetService.deletePredmet(id);
		return new ModelAndView("redirect:/predmet");
	}

}
