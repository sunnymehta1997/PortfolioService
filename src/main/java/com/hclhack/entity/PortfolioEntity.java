package com.hclhack.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="portFolioEntity")
public class PortfolioEntity {
	 
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private String portfolioId;

	    @Column
	    private String assetId;

	    @Column
	    private Integer accountBalance;
	    
	    @Column
	    private String securityName;

	    @Column
	    private String customerName;
	    
	    @ElementCollection
	    @CollectionTable(name="Portfolio_Orders", joinColumns= @JoinColumn(name="portfolio_id"))
	    @Column(name="order_ids")
	    private Set<String> orderIds;

	  


}
