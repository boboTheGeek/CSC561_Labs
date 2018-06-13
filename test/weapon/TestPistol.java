package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;

public class TestPistol
{

	@Test
	public void testNewInstance()
	{
		Pistol shooter1 = new Pistol();
		assertEquals(10, shooter1.baseDamage);
		assertEquals(25, shooter1.getMaxRange());
		assertEquals(2, shooter1.rateOfFire);
		assertEquals(10, shooter1.getMaxAmmo());
	}

	@Test
	public void testDamage()
	{
		Pistol shooter1 = new Pistol();
		Range.distance = 3;
		assertEquals(10, shooter1.damage());
		Range.distance = 26; // outside of range
		assertEquals(0, shooter1.damage());

	}

	
	@Test  //does not do damage if out of ammo
	public void testOutOfAmmo()
	{
		GenericWeapon shooterMcGavin = new Pistol();
		
		for (int x = 100; x >= 0; x-- )
			shooterMcGavin.fire();
		assertEquals(0, shooterMcGavin.currentAmmo);
		assertEquals(0, shooterMcGavin.damage());
	}
	

	@Test
	public void testUpdateAmmo()
	{
		Pistol shooter1 = new Pistol();
		shooter1.fire();
		assertEquals(9, shooter1.currentAmmo);
	}

	@Test
	public void testReload()
	{
		Pistol shooter1 = new Pistol();
		shooter1.fire();
		assertEquals(9, shooter1.currentAmmo);
		shooter1.reload();
		assertEquals(10, shooter1.currentAmmo);
	}

}
