package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.*;

public class RetirementTest {

	@Test
	public void testTotalAmountSaved() {
		
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dExpectedPV = -1454485.55;
		double dSSIAmt = 2642;
		double dRequiredIncome = 10000; 
		
		
		Retirement rt = new Retirement();
		rt.setdAnnualReturnRetired(dAnnualReturn);
		rt.setdMonthlySSI(dSSIAmt);
		rt.setdRequiredIncome(dRequiredIncome);
		rt.setiYearsRetired(iYearsRetired);
		 
		assertEquals(dExpectedPV,rt.TotalAmountSaved(), 0.01);
		
	}

	@Test
	public void testAmountToSave() {
		
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dExpectedPV = -1454485.55;
		double dSSIAmt = 2642;
		double dRequiredIncome = 10000;
		int iYearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		double dExpectedPMT = 554.13;
		
		
		Retirement rt = new Retirement();
		rt.setdAnnualReturnRetired(dAnnualReturn);
		rt.setdMonthlySSI(dSSIAmt);
		rt.setdRequiredIncome(dRequiredIncome);
		rt.setiYearsRetired(iYearsRetired);
		rt.setiYearsToWork(iYearsToWork);
		rt.setdAnnualReturnWorking(dAnnualReturnWorking);

		assertEquals(dExpectedPMT,rt.AmountToSave(), 0.01);
	}
}
