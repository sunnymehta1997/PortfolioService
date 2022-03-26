package com.hclhack.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hclhack.dto.PortfolioSummaryResponse;
import com.hclhack.entity.PortfolioEntity;
import com.hclhack.repository.PortfolioRepository;
import com.hclhack.service.PortfolioService;

class PortfolioServiceImplTest {

	
	@Autowired 
	PortfolioService portfolioService;
	
	@MockBean
	private PortfolioRepository portfolioRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		PortfolioEntity portfolioEntity = new PortfolioEntity();
		portfolioEntity.setAccountBalance(10000);
		portfolioEntity.setPortfolioId("1");
		portfolioEntity.setCustomerName("sunny");
		Optional<PortfolioEntity> portfolioEntityOptional = Optional.of(portfolioEntity);
		Mockito.when(portfolioRepository.findById(1l)).thenReturn(portfolioEntityOptional);
	}

	@Test
	public void testFindPortfolioDetailsById_Success() {
		PortfolioSummaryResponse expectedResponse = new PortfolioSummaryResponse();
		expectedResponse.setAccountbalance(10000);
		expectedResponse.setCustomerName("sunny");
		PortfolioSummaryResponse actualResponse=portfolioService.findPortfolioDetailsById("1");
		assertEquals(expectedResponse, actualResponse);
		
	}

}
