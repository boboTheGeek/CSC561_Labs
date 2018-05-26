/*
 * testing for recovery class
 * Author: Rob Miles
 */

package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryNone
{
	/**
	 * currentLP = maxLP
	 * 		Ensure max life points remain unchanged after recovery period
	 */
	@Test
	public void testMaxLPRetained()
	{
		RecoveryNone recv = new RecoveryNone();
		assertEquals(30, recv.calculateRecovery(30, 30));
		
		//try the same thing via interface
		RecoveryBehavior recv2 = new RecoveryNone();
		assertEquals(25, recv2.calculateRecovery(25, 30));
		
	}
	
	/**
	 * currentLP < maxLP
	 * 		Ensure max life points remain unchanged after recovery period
	 */
	@Test
	public void testLPareLtMax()
	{
		RecoveryNone iamhurt = new RecoveryNone();
		assertEquals(20, iamhurt.calculateRecovery(20, 30));
		
	}
	
	


}
