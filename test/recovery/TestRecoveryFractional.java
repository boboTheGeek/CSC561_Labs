/**
 * testing for recovery class that recovers by some fraction of life points
 * @Author: Rob Miles
 */

package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryFractional
{

	/**
	 * when currentLP = maxLP return current life points
	 */
	@Test
	public void testNoRecoveryWhenNotHurt()
	{
		int maxLifePts = 30;
		int currentLifePts = 30;
		int recoveryFractionSize = 10;
		int expectedRecoveryVal = currentLifePts;
		RecoveryFractional rl = new RecoveryFractional(recoveryFractionSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);

		// just trace for sanity, can ignore
		traceMe("Not hurt", expectedRecoveryVal, result);
	}

	/**
	 * when 0 < maxLP- currentLP < fraction*currentLP (recover to maxLP w/o going
	 * over)
	 */
	@Test
	public void testRecoveryWhenNearlyHealthy()
	{
		int maxLifePts = 30;
		int currentLifePts = 29;
		int recoveryFractionSize = 10;
		int expectedRecoveryVal = maxLifePts;
		RecoveryFractional rl = new RecoveryFractional(recoveryFractionSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);

		// just trace for sanity, can ignore
		traceMe("LP + recovery > Max", expectedRecoveryVal, result);
	}

	/**
	 * when fraction*currentLP < maxLP – currentLP (recover full step) rounds the
	 * fraction up to the next whole number
	 */
	@Test
	public void testRecoveryFullIncrement()
	{
		int maxLifePts = 100;
		int currentLifePts = 83;
		int recoveryStepSize = 10;
		// 83/10=8.3
		// round up to 9
		// 9 + 83 = 92
		int expectedRecoveryVal = 92;
		RecoveryFractional rl = new RecoveryFractional(recoveryStepSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);

		// just trace for sanity, can ignore
		traceMe("FullIncrement", expectedRecoveryVal, result);
	}

	/**
	 * when currentLP = 0 stay dead
	 */
	@Test
	public void testNoRecoveryWhenDead()
	{
		int maxLifePts = 93;
		int currentLifePts = 0;
		int recoveryStepSize = 10;
		int expectedRecoveryVal = 0;
		RecoveryFractional rl = new RecoveryFractional(recoveryStepSize);
		int result = rl.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(expectedRecoveryVal, result);

		// just trace for sanity, can ignore
		traceMe("Dead", expectedRecoveryVal, result);
	}

	/**
	 * don't worry about this: it's just to trace so I can make sure my test cases
	 * are working as expected. [belt and suspenders kind of thing]
	 */
	private void traceMe(String mcname, int expectedRecoveryVal, int result)
	{

		// System.out.println(mcname);
		// System.out.println("\t*expected: " + expectedRecoveryVal + ", got: " +
		// result);

	}

}
