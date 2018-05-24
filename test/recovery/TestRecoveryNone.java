/*
 * testing for recovery class
 * Author: Rob Miles
 */

package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryNone
{
	/*
	 * Ensure max life points remain unchanged after recovery period
	 */
	@Test
	public void testMaxLPRetained()
	{
		RecoveryNone recv = new RecoveryNone();
		assertEquals(0, recv.calculateRecovery(30, 30));
		
	}

}
