package com.example.rewardportalproject.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewardportalproject.entities.CustomerRewards;
import com.example.rewardportalproject.services.CustomerRewardPointsService;



@RestController
@RequestMapping("/customer-rewards")
public class RewardsController {
	
    @Autowired
    private CustomerRewardPointsService rewardsService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Long, CustomerRewards>> getAllCustomerRewards() {
        Map<Long, CustomerRewards> rewards = rewardsService.calculateRewardsForAllCustomers();
        return ResponseEntity.ok()
                           .contentType(MediaType.APPLICATION_JSON)
                           .body(rewards);
    }

}
