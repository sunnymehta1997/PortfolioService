package com.hclhack.service;

import com.hclhack.dto.PortfolioSummaryRequest;
import com.hclhack.dto.PortfolioSummaryResponse;

public interface PortfolioService {
	
	public PortfolioSummaryResponse findPortfolioDetailsById(String portfolioId);
	public PortfolioSummaryResponse savePortFolioDetails(PortfolioSummaryRequest portfolioSummaryRequest);
	public void deletePortFolioDetailsById(String portfolioId);
	public PortfolioSummaryResponse updatePortFolioDetails(PortfolioSummaryRequest portfolioSummaryRequest, String portfolioId);

}
