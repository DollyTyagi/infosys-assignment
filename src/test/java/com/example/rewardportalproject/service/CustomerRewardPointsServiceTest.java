package com.example.rewardportalproject.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.rewardportalproject.entities.CustomerRewards;
import com.example.rewardportalproject.entities.Transactions;
import com.example.rewardportalproject.repository.TransactionRepo;
import com.example.rewardportalproject.services.CustomerRewardPointsServiceImpl;

public class CustomerRewardPointsServiceTest {
	
    @Mock
    private TransactionRepo transactionRepo;
    
    @InjectMocks
    private CustomerRewardPointsServiceImpl rewardsService;
    
    @Test
    void calculateRewardsForAllCustomers_Success() {
 
    Map<Long, CustomerRewards>  result = rewardsService.calculateRewardsForAllCustomers();

        // Assert
        assertNotNull(result);
    
    }

}
