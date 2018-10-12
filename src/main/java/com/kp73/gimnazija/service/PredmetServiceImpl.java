package com.kp73.gimnazija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp73.gimnazija.entities.Predmet;
import com.kp73.gimnazija.repository.PredmetRepository;

@Service("predmetService")
public class PredmetServiceImpl implements PredmetService {
	
	@Autowired
	private PredmetRepository predmetRepository;

	@Override
	public List<Predmet> getAllPredmet() {
		return (List<Predmet>) predmetRepository.findAll();
	}

	@Override
	public Predmet getPredmetById(Long id) {
		return predmetRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(Predmet predmet) {
		predmetRepository.save(predmet);
	}

	@Override
	public void deletePredmet(Long id) {
		predmetRepository.delete(id);

	}

}
