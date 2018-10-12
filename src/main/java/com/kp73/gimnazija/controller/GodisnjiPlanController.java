package com.kp73.gimnazija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kp73.gimnazija.entities.GodisnjiPlan;
import com.kp73.gimnazija.entities.SkolskaGodina;
import com.kp73.gimnazija.service.GodisnjiPlanService;
import com.kp73.gimnazija.service.SkolskaGodinaService;

@Controller
public class GodisnjiPlanController {
	
	@Autowired
	private GodisnjiPlanService godisnjiPlanService;
	
	@Autowired
	private SkolskaGodinaService skolskaGodinaService;
	
	@GetMapping("/addGodisnjiPlan")
	public ModelAndView addGodisnjiPlan() {
		ModelAndView model = new ModelAndView();
		GodisnjiPlan godisnjiPlan = new GodisnjiPlan();
		List<SkolskaGodina> listSkolskaGodina = skolskaGodinaService.getAllSkolskaGodina();
		model.addObject("godisnjiPlanForm", godisnjiPlan);
		model.addObject("listSkolskaGodina", listSkolskaGodina);
		model.setViewName("godisnji_plan_form");
		return model;
	}
	
	@PostMapping("/saveGodisnjiPlan")
	public ModelAndView saveGodisnjiPlan(@ModelAttribute("godisnjiPlanForm") GodisnjiPlan godisnjiPlan) {
		godisnjiPlanService.saveOrUpdate(godisnjiPlan);
		return new ModelAndView("redirect:/addGodisnjiPlan");
	}
	
	@GetMapping("/addSkolskaGodina")
	public ModelAndView addSkolskaGodina() {
		ModelAndView model = new ModelAndView();
		SkolskaGodina skolskaGodina = new SkolskaGodina();
		List<SkolskaGodina> listSkolskaGodina = skolskaGodinaService.getAllSkolskaGodina();
		model.addObject("skolskaGodinaForm", skolskaGodina);
		model.addObject("listSkolskaGodina", listSkolskaGodina);
		model.setViewName("skolska_godina_form");
		return model;
	}
	
	@PostMapping("/saveSkolskaGodina")
	public ModelAndView saveSkolskaGodina(@ModelAttribute("skolskaGodinaForm") SkolskaGodina skolskaGodina) {
		skolskaGodinaService.saveOrUpdate(skolskaGodina);
		return new ModelAndView("redirect:/addSkolskaGodina");
	}

}
