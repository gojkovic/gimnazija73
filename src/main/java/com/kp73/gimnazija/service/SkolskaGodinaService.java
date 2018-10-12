package com.kp73.gimnazija.service;

import java.util.List;

import com.kp73.gimnazija.entities.SkolskaGodina;

public interface SkolskaGodinaService {
	public List<SkolskaGodina> getAllSkolskaGodina();

	public SkolskaGodina getSkolskaGodinaById(Long id);

	public void saveOrUpdate(SkolskaGodina skolskaGodina);

	public void deleteSkolskaGodina(Long id);
}
