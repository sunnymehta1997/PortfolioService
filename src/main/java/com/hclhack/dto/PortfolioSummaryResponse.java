package com.hclhack.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class PortfolioSummaryResponse {
	  private UUID portfolioID;
	    private String assetID;
	    private Integer accountbalance;
	    private String securityName;
	    private String customerName;
	    private List<OrderDetails> orderDetail;
}
