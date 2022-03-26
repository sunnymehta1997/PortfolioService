package com.hclhack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hclhack.controller.PortfolioController;
import com.hclhack.dto.PortfolioSummaryRequest;
import com.hclhack.dto.PortfolioSummaryResponse;
import com.hclhack.entity.PortfolioEntity;
import com.hclhack.exception.RecordNotFoundException;
import com.hclhack.repository.PortfolioRepository;
import com.hclhack.service.PortfolioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@CacheConfig(cacheNames="portfolioCache")
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portfolioRepository;
	
	@Override
	@Cacheable(cacheNames="portfolioCache")
	public PortfolioSummaryResponse findPortfolioDetailsById(String portfolioId) {
		log.info("Calling findPortfolioDetailsById method ");
		PortfolioSummaryResponse portfolioSummaryResponse= new PortfolioSummaryResponse();
		PortfolioEntity portfolioEntity = portfolioRepository.findById(Long.valueOf(portfolioId)).orElseThrow(() -> new RecordNotFoundException("Portfolio Id Doesn't exis"));
		portfolioSummaryResponse.setAccountbalance(portfolioEntity.getAccountBalance());
		portfolioSummaryResponse.setCustomerName(portfolioEntity.getCustomerName());
		return portfolioSummaryResponse;
	}
	@Override
	@CachePut(cacheNames="portfolioCache" )
	public PortfolioSummaryResponse savePortFolioDetails(PortfolioSummaryRequest portfolioSummaryRequest) {
		PortfolioEntity portfolioEntity = new PortfolioEntity();
		portfolioEntity.setAccountBalance(portfolioSummaryRequest.getAccountbalance());
		portfolioEntity.setCustomerName(portfolioSummaryRequest.getCustomerName());
		portfolioEntity = portfolioRepository.save(portfolioEntity);
		return null;
	}
	@Override
	@CacheEvict(cacheNames="portfolioCache")
	public void deletePortFolioDetailsById(String portfolioId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	@CachePut(cacheNames="portfolioCache" )
	public PortfolioSummaryResponse updatePortFolioDetails(PortfolioSummaryRequest portfolioSummaryRequest, String portfolioId) {
		PortfolioSummaryResponse portfolioSummaryResponse= new PortfolioSummaryResponse();
		PortfolioEntity portfolioEntity =portfolioRepository.findById(Long.valueOf(portfolioId)).orElseThrow(() -> new RecordNotFoundException("Portfolio Id Doesn't exis"));
		portfolioEntity.setAccountBalance(portfolioSummaryRequest.getAccountbalance());
		portfolioEntity = portfolioRepository.save(portfolioEntity);
		portfolioSummaryResponse.setAccountbalance(portfolioEntity.getAccountBalance());
		return portfolioSummaryResponse;
	}

}
