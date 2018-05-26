/*
 * Author: Rob Miles
 */
package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryLinear
{
	boolean trace = false;

	/**
	 * when currentLP = maxLP
	 * 
	 */
	@Test
	public void testNoRecoveryWhenNotHurt()
	{
		int maxLifePts = 30;
		int currentLifePts = 30;
		int recoveryStepSize = 3;
		int expectedRecoveryVal = currentLifePts;
		RecoveryLinear rl = new RecoveryLinear(recoveryStepSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);

		// just trace for sanity, can ignore
		traceMe("Not hurt", expectedRecoveryVal, result);
	}

	/**
	 * when 0 < maxLP- currentLP < step (recover to maxLP w/o going over)
	 * 
	 */
	@Test
	public void testRecoveryWhenNearlyHealthy()
	{
		int maxLifePts = 30;
		int currentLifePts = 28;
		int recoveryStepSize = 3;
		int expectedRecoveryVal = maxLifePts;
		RecoveryLinear rl = new RecoveryLinear(recoveryStepSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);
		
		// just trace for sanity, can ignore
		traceMe("LP + recovery > Max", expectedRecoveryVal, result);
	}

	/**
	 * when step < maxLP – currentLP (recover full step)
	 * 
	 */
	@Test
	public void testRecoveryFullIncrement()
	{
		int maxLifePts = 30;
		int currentLifePts = 20;
		int recoveryStepSize = 3;
		int expectedRecoveryVal = currentLifePts + recoveryStepSize;
		RecoveryLinear rl = new RecoveryLinear(recoveryStepSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);
		
		// just trace for sanity, can ignore
		traceMe("FullIncrement", expectedRecoveryVal, result);
	}

	/**
	 * when step < maxLP – currentLP (recover full step)
	 * 
	 */
	@Test
	public void testNoRecoveryWhenDead()
	{
		int maxLifePts = 30;
		int currentLifePts = 0;
		int recoveryStepSize = 3;
		int expectedRecoveryVal = 0;
		RecoveryLinear rl = new RecoveryLinear(recoveryStepSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);
		
		// just trace for sanity, can ignore
		traceMe("Dead", expectedRecoveryVal, result);
	}

	
	/**
	 * don't worry about this, it's just to trace so I can make sure my test cases
	 * are working as expected. [belt and suspenders kind of thing]
	 */
	private void traceMe(String mcname, int expectedRecoveryVal, int result)
	{
		if (trace == true)
		{
			System.out.println(mcname);
			System.out.println("\t*expected: " + expectedRecoveryVal + ", got: " + result);
		}
	}

}
