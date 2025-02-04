package com.example.rewardportalproject.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRewards {
	
	private Long customerId;
    private int monthlyRewards;
    private int totalRewards;
    
}