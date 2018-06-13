/**
 * @author Rob M, Chandana G
 */

package weapon;

import org.junit.Test;

import gameplay.SimpleTimer;
import static org.junit.Assert.*;

public class TestGenericWeapon
{

	@Test // uses ammo when fired
	public void testFire()
	{
		GenericWeapon RonaldThump = new MockPistol();
		assertEquals(94, RonaldThump.currentAmmo);
		RonaldThump.fire();
		assertEquals(93, RonaldThump.currentAmmo);

	}
	// rate of fire works correctly with simple timer

	@Test // can be reloaded
	public void testReload()
	{
		GenericWeapon shootieMcTootie = new MockPistol();

		shootieMcTootie.fire();
		shootieMcTootie.fire();
		shootieMcTootie.fire();
		shootieMcTootie.fire(); // the guy MUST be dead by now!!!
		assertEquals(90, shootieMcTootie.currentAmmo);
		shootieMcTootie.reload();
		assertEquals(96, shootieMcTootie.currentAmmo);

	}

	@Test // does not do damage if out of ammo
	public void testDamage()
	{
		GenericWeapon shooterMcGavin = new Pistol();

		for (int x = 100; x >= 0; x--)
			shooterMcGavin.fire();
		assertEquals(0, shooterMcGavin.currentAmmo);
		assertEquals(0, shooterMcGavin.damage());
	}

	// does no damage (but does fire) if target beyond max range
	@Test
	public void testFireRate()
	{
		GenericWeapon restrictorshotgun1 = new MockPistol();
		SimpleTimer timeMe = new SimpleTimer(1000);
		timeMe.addTimeObserver(restrictorshotgun1);
		assertEquals(97, restrictorshotgun1.shotCounter);
		assertEquals(89, restrictorshotgun1.damage());
		for (int x = 120; x >= 0; x--)
		{
			restrictorshotgun1.damage();  //deplete remaining turns per rate
		}
		//
		assertEquals(0, restrictorshotgun1.damage());
		timeMe.timeChanged();
		assertEquals(97, restrictorshotgun1.shotCounter);
		for (int x = 100; x >= 0; x--)
		{
			restrictorshotgun1.damage();  //deplete remaining turns per rate
		}
		restrictorshotgun1.reload();
		for (int x = 100; x >= 0; x--)
		{
			restrictorshotgun1.damage();  //deplete remaining turns per rate
		}
		assertEquals(0, restrictorshotgun1.shotCounter);
		assertEquals(0, restrictorshotgun1.damage());
	}

	@Test
	public void testInitialize()
	{
		GenericWeapon shootieMcTootie = new MockPistol();
		assertEquals(96, shootieMcTootie.getMaxAmmo());
	}

	@Test
	public void testUpdateTime()
	{
		GenericWeapon shootieMcTootie = new MockPistol();
		shootieMcTootie.updateTime(22);
		assertEquals(22, shootieMcTootie.currentTime);

	}

	@Test
	public void testGetMaxAmmo()
	{
		GenericWeapon LoiseBelcher = new MockPistol();
		assertEquals(96, LoiseBelcher.getMaxAmmo());

	}

	@Test
	public void testGetMaxRange()
	{
		GenericWeapon shootieMcTootie = new MockPistol();
		assertEquals(98, shootieMcTootie.getMaxRange());

	}

}

class MockPistol extends GenericWeapon
{

	MockPistol()
	{
		baseDamage = 99;
		maxRange = 98;
		rateOfFire = 97;
		maxAmmo = 96;
		currentTime = 95;
		currentAmmo = 94;
		shotCounter = 97;
	}

	/**
	 * Returns the amount of damage caused by the weapon at hand (pun intended :)
	 */
	@Override
	public int damageCalculation()
	{

		return baseDamage - 10;

	}

}