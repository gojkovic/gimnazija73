package com.kp73.gimnazija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kp73.gimnazija.entities.GodisnjiPlan;
import com.kp73.gimnazija.entities.NastavniPlanPredmet;
import com.kp73.gimnazija.entities.Predmet;
import com.kp73.gimnazija.service.GodisnjiPlanService;
import com.kp73.gimnazija.service.NastavniPlanPredmetService;
import com.kp73.gimnazija.service.PredmetService;

@Controller
public class NastavniPlanPredmetController {

	@Autowired
	private NastavniPlanPredmetService nastavniPlanPredmetService;

	@Autowired
	private PredmetService predmetService;
	
	@Autowired
	private GodisnjiPlanService godisnjiPlanService;

	@GetMapping("/nastavni_plan_predmet")
	public ModelAndView nastavniPlanPredmet() {
		ModelAndView modelAndView = new ModelAndView();
		List<NastavniPlanPredmet> nastavniPlanPredmetList = nastavniPlanPredmetService.getAllNastavniPlanPredmet();
		modelAndView.addObject("nastavniPlanPredmetList", nastavniPlanPredmetList);
		modelAndView.setViewName("nastavni_plan_predmet");
		return modelAndView;
	}

	@GetMapping("/addNastavniPlanPredmet")
	public ModelAndView addNastavniPlanPredmet() {
		ModelAndView model = new ModelAndView();
		NastavniPlanPredmet nastavniPlanPredmet = new NastavniPlanPredmet();
		List<Predmet> listPredmet = predmetService.getAllPredmet();
		List<GodisnjiPlan> listGodisnjiPlan = godisnjiPlanService.getAllGodisnjiPlan();
		model.addObject("nastavniPlanPredmetForm", nastavniPlanPredmet);
		model.addObject("listPredmet", listPredmet);
		model.addObject("listGodisnjiPlan", listGodisnjiPlan);
		model.setViewName("nastavni_plan_predmet_form");
		return model;
	}

	@GetMapping("/editNastavniPlanPredmet/{id}")
	public ModelAndView editNastavniPlanPredmet(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		NastavniPlanPredmet nastavniPlanPredmet = nastavniPlanPredmetService.getNastavniPlanPredmetById(id);
		List<Predmet> listPredmet = predmetService.getAllPredmet();
		List<GodisnjiPlan> listGodisnjiPlan = godisnjiPlanService.getAllGodisnjiPlan();
		model.addObject("nastavniPlanPredmetForm", nastavniPlanPredmet);
		model.addObject("listPredmet", listPredmet);
		model.addObject("listGodisnjiPlan", listGodisnjiPlan);
		model.setViewName("nastavni_plan_predmet_form");
		return model;
	}

	@PostMapping("/saveNastavniPlanPredmet")
	public ModelAndView saveNastavniPlanPredmet(
			@ModelAttribute("nastavniPlanPredmetForm") NastavniPlanPredmet nastavniPlanPredmet) {
		nastavniPlanPredmetService.saveOrUpdate(nastavniPlanPredmet);
		return new ModelAndView("redirect:/nastavni_plan_predmet");
	}

	@GetMapping("/deleteNastavniPlanPredmet/{id}")
	public ModelAndView delete(@PathVariable("id") long id) {
		nastavniPlanPredmetService.deleteNastavniPlanPredmet(id);
		return new ModelAndView("redirect:/nastavni_plan_predmet");
	}

}
