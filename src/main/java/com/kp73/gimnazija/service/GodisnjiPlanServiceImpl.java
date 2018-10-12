package com.kp73.gimnazija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp73.gimnazija.entities.GodisnjiPlan;
import com.kp73.gimnazija.repository.GodisnjiPlanRepository;

@Service("godisnjiPlanService")
public class GodisnjiPlanServiceImpl implements GodisnjiPlanService {
	
	@Autowired
	private GodisnjiPlanRepository godisnjiPlanRepository;

	@Override
	public List<GodisnjiPlan> getAllGodisnjiPlan() {
		return (List<GodisnjiPlan>) godisnjiPlanRepository.findAll();
	}

	@Override
	public GodisnjiPlan getGodisnjiPlanById(Long id) {
		return godisnjiPlanRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(GodisnjiPlan godisnjiPlan) {
		godisnjiPlanRepository.save(godisnjiPlan);

	}

	@Override
	public void deleteGodisnjiPlan(Long id) {
		godisnjiPlanRepository.delete(id);

	}

}
