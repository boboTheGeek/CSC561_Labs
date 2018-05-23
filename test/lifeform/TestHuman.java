package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHuman
{
	
	
	/*
	 * test we can construct a Human with initial (armor, a name, and life points)
	 */
	@Test
	public void testInitalizationHuman()
	{
		Human entity;
		entity = new Human(0, "Fred", 50);
		assertEquals("Fred", entity.getName());
		assertEquals(50, entity.getCurrentLifePoints());
		assertEquals(0, entity.getArmorPoints());
		

	}
	
	
	/*
	 * test we can set armor points
	 * and that it changes values < 0 equal to 0
	 */
	@Test
	public void testSetArmor()
	{
		Human entity;
		entity = new Human(0, "Rudolph", 50);
		
		entity.setArmorPoints(5);
		assertEquals(5, entity.getArmorPoints());
		
		entity.setArmorPoints(-3);
		assertEquals(0, entity.getArmorPoints());
	}

}
