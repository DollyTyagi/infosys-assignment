package com.example.rewardportalproject.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.example.rewardportalproject.entities.CustomerRewards;
import com.example.rewardportalproject.entities.Transactions;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class CustomerRewardPointsServiceImpl implements CustomerRewardPointsService{
	
	
	 @PersistenceContext
	    private EntityManager entityManager;
	    @Override
	    public Map<Long, CustomerRewards> calculateRewardsForAllCustomers() {
	        List<Transactions> transactions = entityManager.createQuery(
	            "SELECT t FROM Transaction t", Transactions.class).getResultList();
	        
	        Map<Long, CustomerRewards> rewardsMap = new HashMap<>();
	        
	        for (Transactions transaction : transactions) {
	            Long customerId = transaction.getCustomerId();
	            int points = calculatePoints(transaction.getAmount());
	            
	            CustomerRewards rewards =  rewardsMap.computeIfAbsent(customerId, k -> new CustomerRewards(customerId, 0, 0));
	            rewards.setTotalRewards(rewards.getTotalRewards() + points);
	            rewards.setMonthlyRewards(rewards.getMonthlyRewards() + points); // Simplified for demo
	        }
	        
	        return rewardsMap;
	    }
	    
	    private int calculatePoints(double amount) {
	        int points = 0;
	        if (amount > 100) {
	            points += (int) ((amount - 100) * 2);
	            points += 50; // 1 point for each dollar between 50 and 100
	        } else if (amount > 50) {
	            points += (int) (amount - 50);
	        }
	        return points;
	    }
}