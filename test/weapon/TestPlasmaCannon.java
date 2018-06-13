package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Range;

/**
 * overrides the generic weapon abstract class to provide characteristic
 * features for instance variables as well as a specific override of the damage
 * method calculated on plasma canno specific parameters
 * 
 * @author Chandana G (Pilot), Rob M (co-pilot)
 *
 */
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

	@Test
	public void testDamage()
	{

		Range.distance = 15;
		assertEquals(37, pc.damage());
		Range.distance = 25;
		assertEquals(0, pc.damage());

	}

	@Test
	public void testUpdateAmmo()
	{
		pc.fire();
		assertEquals(3, pc.currentAmmo);
	}

	@Test
	public void testReload()
	{
		pc.fire();
		assertEquals(3, pc.currentAmmo);
		pc.reload();
		assertEquals(4, pc.currentAmmo);
	}

}
