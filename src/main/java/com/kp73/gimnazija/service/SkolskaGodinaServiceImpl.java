package com.kp73.gimnazija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp73.gimnazija.entities.SkolskaGodina;
import com.kp73.gimnazija.repository.SkolskaGodinaRepository;

@Service("skolskaGodinaService")
public class SkolskaGodinaServiceImpl implements SkolskaGodinaService {
	
	@Autowired
	private SkolskaGodinaRepository skolskaGodinaRepository;

	@Override
	public List<SkolskaGodina> getAllSkolskaGodina() {
		return (List<SkolskaGodina>) skolskaGodinaRepository.findAll();
	}

	@Override
	public SkolskaGodina getSkolskaGodinaById(Long id) {
		return skolskaGodinaRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(SkolskaGodina skolskaGodina) {
		skolskaGodinaRepository.save(skolskaGodina);

	}

	@Override
	public void deleteSkolskaGodina(Long id) {
		skolskaGodinaRepository.delete(id);

	}

}
