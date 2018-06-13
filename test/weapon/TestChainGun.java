package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;

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

	@Test
	public void testDamage()
	{
		Range.distance = 35;
		assertEquals(0, cg.damage());
		Range.distance = 29; 
		assertEquals(14, cg.damage());

	}
	@Test
	public void testUpdateAmmo()
	{
		cg.fire();
		assertEquals(39, cg.currentAmmo);
	}
	@Test
	public void testReload()
	{
		cg.fire();
		assertEquals(39, cg.currentAmmo);
		cg.reload();
		assertEquals(40, cg.currentAmmo);
	}


}
