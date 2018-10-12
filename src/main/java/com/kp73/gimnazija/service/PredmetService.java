package com.kp73.gimnazija.service;

import java.util.List;

import com.kp73.gimnazija.entities.Predmet;

public interface PredmetService {
	public List<Predmet> getAllPredmet();

	public Predmet getPredmetById(Long id);

	public void saveOrUpdate(Predmet predmet);

	public void deletePredmet(Long id);
}
