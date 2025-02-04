package com.example.rewardportalproject.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.rewardportalproject.controllers.RewardsController;
import com.example.rewardportalproject.services.CustomerRewardPointsService;

public class RewardsControllerTest {
	
    @Mock
    private CustomerRewardPointsService rewardsService;

    @InjectMocks
    private RewardsController rewardsController;

}
