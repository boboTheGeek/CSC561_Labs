/*
 * Author: Rob Miles
 */
package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryLinear
{

	@Test
	public void testNoRecoveryWhenNotHurt()
	{
		RecoveryLinear rl = new RecoveryLinear(3);
		int maxLifePts = 30;
		int result = rl.calculateRecovery(maxLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}

}
