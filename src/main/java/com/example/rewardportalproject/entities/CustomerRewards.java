package com.example.rewardportalproject.entities;

public class CustomerRewards {
	
	private Long customerId;
    private int monthlyRewards;
    private int totalRewards;
    
    
   
	public CustomerRewards(Long customerId, int monthlyRewards, int totalRewards) {
		super();
		this.customerId = customerId;
		this.monthlyRewards = monthlyRewards;
		this.totalRewards = totalRewards;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public int getMonthlyRewards() {
		return monthlyRewards;
	}
	public void setMonthlyRewards(int monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}
	public int getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}	

}