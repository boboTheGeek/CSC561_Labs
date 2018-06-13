/**
 * testing for scope attachment
 * 
 * @author Rob Miles
 */

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
		assertEquals(178, inSight.damage());
	}

	@Test
	public void test2Attachments()
	{
		Range.distance = 0;
		Weapon myGun = new MockPistol();
		Scope inSight = new Scope(myGun);

		// 89 * (1 + ((98 - 0)/98)) =  [aka 89 *2]
		assertEquals(178, inSight.damage());
		

		Scope inSight2 = new Scope(inSight);
		 //178 * (1 + ((98 - 0)/98)) = 356  [aka 178 * 2]
		assertEquals(366, inSight2.damage());
	}

}
