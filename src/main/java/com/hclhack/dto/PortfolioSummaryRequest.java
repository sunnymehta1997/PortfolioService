package com.hclhack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioSummaryRequest {
	 private Integer accountbalance;
	  private String customerName;
}
