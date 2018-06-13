package weapon;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestGenericWeapon
{

	@Test
	public void testInitialize()
	{
		GenericWeapon shootieMcTootie = new MockPistol();
		assertEquals(96, shootieMcTootie.getMaxAmmo());
	}

	@Test
	public void testDamage()
	{
		GenericWeapon shooterMcGavin = new MockPistol();
		assertEquals(99, shooterMcGavin.damage());
	}

	@Test
	public void testFire()
	{
		GenericWeapon RonaldThump = new MockPistol();
		RonaldThump.fire();
		assertEquals(93, RonaldThump.currentAmmo);

	}

	@Test
	public void testReload()
	{
		GenericWeapon shootieMcTootie = new MockPistol();
		shootieMcTootie.fire();
		shootieMcTootie.fire();
		shootieMcTootie.fire();
		shootieMcTootie.fire(); // the guy MUST be dead by now!!!
		shootieMcTootie.reload();
		assertEquals(96, shootieMcTootie.currentAmmo);

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

	// @Test
	// public void testFireRate()
	// {
	// GenericWeapon restrictorshotgun1 = new MockPistol();
	// //SimpleTimer timeMe = new SimpleTimer(1000);
	// //TimeObserver newObserver1 = new TimeObserver();
	// //timeMe.addTimeObserver(newObserver1);
	//
	// restrictorshotgun1.damage();
	// restrictorshotgun1.damage();
	// restrictorshotgun1.damage();
	//
	//
	// assertEquals(99,restrictorshotgun1.damage());
	//
	// }

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
	}

	/**
	 * Returns the amount of damage caused by the weapon at hand (pun intended :)
	 */
	public int damage()
	{
		return baseDamage;

	}

}