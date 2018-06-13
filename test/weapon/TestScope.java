package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;

public class TestScope
{

	@Test
	public void testDamage()
	{

		Range.distance = 0;
		Weapon myGun = new MockPistol();
		Scope inSight = new Scope(myGun);
		// 99 * (1 + ((98 - 0)/98)) = 198
		assertEquals(198, inSight.damage());
	}

}
