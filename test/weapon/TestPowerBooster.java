package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;

public class TestPowerBooster {

	//@Test
	/*public void testInitialize() {
		Weapon chaingun = new MockChainGun();
		PowerBooster pb = new PowerBooster(chaingun);
		assertEquals(194, pb.damage());
	}
		*/
	@Test
	public void test2Attachments()
	{
		Weapon chaingun = new MockChainGun();
		PowerBooster pb = new PowerBooster(chaingun);
		assertEquals(194, pb.damage());
		pb = new PowerBooster(pb);
		assertEquals(381, pb.damage());
	}
	

}
