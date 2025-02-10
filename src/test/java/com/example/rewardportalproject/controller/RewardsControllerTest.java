package com.example.rewardportalproject.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.rewardportalproject.controllers.RewardsController;
import com.example.rewardportalproject.entities.CustomerRewards;
import com.example.rewardportalproject.services.CustomerRewardPointsService;

public class RewardsControllerTest {

    @Mock
    private CustomerRewardPointsService rewardsService;

    @InjectMocks
    private RewardsController rewardsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomerRewards() {
        // Setup test data
        Map<Long, CustomerRewards> mockRewards = new HashMap<>();
        mockRewards.put(1, new CustomerRewards(1, 100, 300));
        
        // Mock service behavior
        when(rewardsService.calculateRewardsForAllCustomers()).thenReturn(mockRewards);
        
        // Execute the controller method
        ResponseEntity<Map<Long, CustomerRewards>> response = rewardsController.getAllCustomerRewards();
        
        // Verify results
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(mockRewards, response.getBody());
    }
}