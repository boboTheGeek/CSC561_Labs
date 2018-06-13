package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPowerBooster {

	@Test
	public void testInitialize() {
		Weapon chaingun = new MockChainGun();
		PowerBooster pb = new PowerBooster(chaingun);
		assertEquals(99, pb.damage());
	}
		
	

}
