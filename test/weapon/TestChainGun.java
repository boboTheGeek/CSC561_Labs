package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;
/**
 * Tests for the Pistol
 * @author Chandana.G, Rob M
 *
 */
public class TestChainGun
{

	ChainGun cg = new ChainGun();
	@Test
	public void testInitilization()
	{
		
		assertEquals(15, cg.baseDamage);
		assertEquals(30, cg.getMaxRange());
		assertEquals(4, cg.rateOfFire);
		assertEquals(40, cg.getMaxAmmo());
	}
	/**
	 * Tests for checking the amount of damage done by the weapon when 
	 * the target is within max range and outside the max range
	 */
	@Test
	public void testDamage()
	{
		Range.distance = 35;
		assertEquals(0, cg.damage());
		Range.distance = 29; 
		assertEquals(14, cg.damage());

	}
	/**
	 * Test for checking the damage if out of ammo, which should return no damage
	 */
	@Test 
	public void testOutOfAmmo()
	{
		GenericWeapon gw = new ChainGun();

		for (int x = 100; x >= 0; x--)
			gw.fire();
		assertEquals(0, gw.currentAmmo);
		assertEquals(0, gw.damage());
	}
	/**
	 * It returns the updated current ammo for the weapon after the weapon's fired 
	 */
	@Test
	public void testUpdateAmmo()
	{
		cg.fire();
		assertEquals(39, cg.currentAmmo);
	}
	/**
	 * Reloads the weapon by setting its current ammo to the max ammo
	 */
	@Test
	public void testReload()
	{
		cg.fire();
		assertEquals(39, cg.currentAmmo);
		cg.reload();
		assertEquals(40, cg.currentAmmo);
	}


}
