package com.hclhack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hclhack.dto.PortfolioSummaryRequest;
import com.hclhack.dto.PortfolioSummaryResponse;
import com.hclhack.service.PortfolioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pms")
@Slf4j
public class PortfolioController {
	
	@Autowired
	PortfolioService portfolioService;
	
	@GetMapping(path="/portfolioSummaryById")
	public ResponseEntity<PortfolioSummaryResponse> portfolioSummaryById(@RequestParam String portfolioId){
		log.info("portfolioSummaryById method called");
		PortfolioSummaryResponse portfolioSummaryResponse=portfolioService.findPortfolioDetailsById(portfolioId);
		return new ResponseEntity<PortfolioSummaryResponse>(portfolioSummaryResponse, HttpStatus.OK);
		
	}
	
	@PostMapping(path="/portfolioSummary")
	public ResponseEntity<PortfolioSummaryResponse> savePortfolioSummary(@RequestBody PortfolioSummaryRequest portfolioRequest){
		log.info("portfolioSummaryById method called");
		PortfolioSummaryResponse portfolioSummaryResponse= portfolioService.savePortFolioDetails(portfolioRequest);
		return new ResponseEntity<PortfolioSummaryResponse>(portfolioSummaryResponse, HttpStatus.OK);
		
	}
	
	@PutMapping(path="/portfolioSummary")
	public ResponseEntity<PortfolioSummaryResponse> upDatePortfolioSummary(@RequestBody PortfolioSummaryRequest portfolioRequest){
		log.info("portfolioSummaryById method called");
		PortfolioSummaryResponse portfolioSummaryResponse=  portfolioService.savePortFolioDetails(portfolioRequest);
		return new ResponseEntity<PortfolioSummaryResponse>(portfolioSummaryResponse, HttpStatus.OK);
		
	}

}
