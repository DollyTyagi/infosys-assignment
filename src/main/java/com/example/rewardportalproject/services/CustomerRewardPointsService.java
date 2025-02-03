package com.example.rewardportalproject.services;

import java.util.Map;
import com.example.rewardportalproject.entities.CustomerRewards;

public interface CustomerRewardPointsService {
	
	Map<Long, CustomerRewards> calculateRewardsForAllCustomers();

}
