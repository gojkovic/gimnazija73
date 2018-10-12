package com.kp73.gimnazija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp73.gimnazija.entities.NastavniPlanPredmet;
import com.kp73.gimnazija.repository.NastavniPlanPredmetRepository;

@Service("nastavniPlanPredmetService")
public class NastavniPlanPredmetServiceImpl implements NastavniPlanPredmetService {
	
	@Autowired
	private NastavniPlanPredmetRepository nastavniPlanPredmetRepository;

	@Override
	public List<NastavniPlanPredmet> getAllNastavniPlanPredmet() {
		return (List<NastavniPlanPredmet>) nastavniPlanPredmetRepository.findAll();
	}

	@Override
	public NastavniPlanPredmet getNastavniPlanPredmetById(Long id) {
		return nastavniPlanPredmetRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(NastavniPlanPredmet nastavniPlanPredmet) {
		nastavniPlanPredmetRepository.save(nastavniPlanPredmet);

	}

	@Override
	public void deleteNastavniPlanPredmet(Long id) {
		nastavniPlanPredmetRepository.delete(id);

	}

}
