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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.rewardportalproject.controllers.RewardsController;
import com.example.rewardportalproject.entities.CustomerRewards;
import com.example.rewardportalproject.services.CustomerRewardPointsService;

public class RewardsControllerTest {

    @Mock
    private CustomerRewardPointsService rewardsService;

    @InjectMocks
    private RewardsController rewardsController;
    
    @Autowired
    private MockMvc mockMvc;

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
    
    @Test
    void getAllCustomerRewards_ShouldReturnRewards() throws Exception {
        // Given
        when(rewardsService.calculateRewardsForAllCustomers()).thenReturn(mockRewards);

        // When & Then
        mockMvc.perform(get("/customer-rewards")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(rewardsService, times(1)).calculateRewardsForAllCustomers();
    }
}