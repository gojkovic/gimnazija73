package com.kp73.gimnazija.service;

import java.util.List;

import com.kp73.gimnazija.entities.NastavniPlanPredmet;

public interface NastavniPlanPredmetService {
	public List<NastavniPlanPredmet> getAllNastavniPlanPredmet();

	public NastavniPlanPredmet getNastavniPlanPredmetById(Long id);

	public void saveOrUpdate(NastavniPlanPredmet nastavniPlanPredmet);

	public void deleteNastavniPlanPredmet(Long id);
}
