package com.example.rewardportalproject.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.rewardportalproject.entities.CustomerRewards;
import com.example.rewardportalproject.entities.Transactions;
import com.example.rewardportalproject.services.CustomerRewardPointsServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import static org.mockito.Mockito.*;

public class CustomerRewardPointsServiceImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Transactions> query;

    @InjectMocks
    private CustomerRewardPointsServiceImpl rewardsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateRewardsForAllCustomers() {
        // Setup test transactions
        Transactions transaction1 = new Transactions(1, 1, 120.0, LocalDate.now());
        Transactions transaction2 = new Transactions(2, 1, 85.0, LocalDate.now());
        
        when(entityManager.createQuery(anyString(), eq(Transactions.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(transaction1, transaction2));

        // Execute service method
        Map<Long, CustomerRewards> result = rewardsService.calculateRewardsForAllCustomers();

        // Verify rewards calculation
        assertNotNull(result);
        assertTrue(result.containsKey(1L));
        CustomerRewards rewards = result.get(1L);
        assertEquals(1L, rewards.getCustomerId());
        // For $120 transaction: 2*(20) + 50 = 90 points
        // For $85 transaction: 35 points
        // Total should be 125 points
        assertEquals(125, rewards.getTotalRewards());
    }
}