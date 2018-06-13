/**
 * Tests for Power booster attachment
 * 
 * @author Chandana G, Rob Miles
 */
package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;

public class TestPowerBooster {
	/** 
	 * Test for weapon with one attachment 
	 */
	@Test
	public void testInitialize() {
		Weapon chaingun = new MockChainGun();
		PowerBooster pb = new PowerBooster(chaingun);
		assertEquals(195, pb.damage());
	}
	/** 
	 * Test for weapon with two attachments 
	 */	
	@Test
	public void test2Attachments()
	{
		Weapon chaingun = new MockChainGun();
		PowerBooster pb = new PowerBooster(chaingun); 
		assertEquals(195, pb.damage());
		PowerBooster pb2 = new PowerBooster(pb);		
		assertEquals(381, pb2.damage());
	}
	

}
