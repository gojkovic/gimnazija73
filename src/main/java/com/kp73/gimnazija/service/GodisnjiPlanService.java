package com.kp73.gimnazija.service;

import java.util.List;

import com.kp73.gimnazija.entities.GodisnjiPlan;

public interface GodisnjiPlanService {
	public List<GodisnjiPlan> getAllGodisnjiPlan();

	public GodisnjiPlan getGodisnjiPlanById(Long id);

	public void saveOrUpdate(GodisnjiPlan godisnjiPlan);

	public void deleteGodisnjiPlan(Long id);
}
