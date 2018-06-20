/**
 * overrides the generic weapon abstract class to provide characteristic
 * features for instance variables as well as a specific override of the damage
 * method calculated on plasma cannon specific parameters
 * 
 * @author Chandana G, Rob M 
 *
 */
package weapon;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestPlasmaCannon
{

	PlasmaCannon pc = new PlasmaCannon();

	@Test
	public void testInitilization()
	{

		assertEquals(50, pc.baseDamage);
		assertEquals(20, pc.getMaxRange());
		assertEquals(1, pc.rateOfFire);
		assertEquals(4, pc.getMaxAmmo());
	}
	/**
	 * Tests for checking the amount of damage done by the weapon when 
	 * the target is within max range and outside the max range
	 */
	@Test
	public void testDamage()
	{

		//Range.distance = 15;
		assertEquals(37, pc.damage(15));
		//Range.distance = 25;
		assertEquals(0, pc.damage(25));

	}
	/**
	 * It returns the updated current ammo for the weapon after the weapon's fired, 
	 */
	@Test
	public void testUpdateAmmo()
	{
		pc.fire();
		assertEquals(3, pc.currentAmmo);
	}
	/**
	 * Reloads the weapon by setting its current ammo to the max ammo
	 */
	@Test
	public void testReload()
	{
		pc.fire();
		assertEquals(3, pc.currentAmmo);
		pc.reload();
		assertEquals(4, pc.currentAmmo);
	}

}
