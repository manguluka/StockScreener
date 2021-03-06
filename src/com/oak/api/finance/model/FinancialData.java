package com.oak.api.finance.model;

import java.util.Date;
import java.util.SortedMap;

import org.apache.commons.collections4.MapUtils;

import com.google.common.collect.Maps;
import com.oak.external.finance.model.economy.IncomeStatement;

import lombok.Data;

@Data
public class FinancialData {
	
	private final String symbol;
	private final SortedMap<Date,BalanceSheet>annualBalanceSheet;
	private final SortedMap<Date,BalanceSheet>quarterlyBalanceSheet;
	private final SortedMap<Date,CashFlowStatement>annualCashflowStatement;
	private final SortedMap<Date,CashFlowStatement>quarterlyCashflowStatement;
	private final SortedMap<Date,IncomeStatement>annualIncomeStatement;
	private final SortedMap<Date,IncomeStatement>quarterlyIncomeStatement;
	
	
	public static FinancialData blankFinanicalData(String symbol) {
		return new FinancialData(symbol, Maps.newTreeMap(), Maps.newTreeMap(), 
				/* annualCashflowStatement */ null, 
				/* quarterlyCashflowStatement */ null, 
				/* annualIncomeStatement */ null, 
				/* quarterlyIncomeStatement */ null);
	}
	public static boolean isBlank(FinancialData financialData) {
		boolean ret = financialData == null ||
				financialData.isBlank();
		return ret;
	}
	public boolean isBlank() {
		boolean ret =
				MapUtils.isEmpty(annualBalanceSheet) 
				&& MapUtils.isEmpty(quarterlyBalanceSheet)
				&& MapUtils.isEmpty(annualCashflowStatement) 
				&& MapUtils.isEmpty(quarterlyCashflowStatement)
				&& MapUtils.isEmpty(annualIncomeStatement) 
				&& MapUtils.isEmpty(quarterlyIncomeStatement);
		
		return ret;
	}
}
