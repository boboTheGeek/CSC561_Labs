/**
 * Testing for Human class
 * 
 * @Author:  Rob Miles
 */
package lifeform;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RException;

public class TestHuman
{

	
	@Before //clear and setup the world before each test
	public void testSetupWorld() throws RException {
		Environment.resetWorld();
		Environment.createWorld(10, 10);
	}
	/*
	 * test we can construct a Human with initial (armor, a name, and life points)
	 */
	@Test
	public void testInitalizationHuman()
	{
		Human entity;
		entity = new Human(0, "Fred", 50);
		assertEquals("Fred", entity.getName());
		assertEquals(50, entity.getLifePoints());
		assertEquals(0, entity.getArmorPoints());
		assertEquals(5, entity.getAttackStrength());
		assertEquals(3, entity.getSpeed());
	}

/**
 * beyond this point you're getting into old labs like #5..  ew...
 * 
 * 
 * 
 * 
 * 
 * 
 */

	/*
	 * armor absorbs all damage using takeHit() when damage < armor
	 */
	@Test
	public void testArmorProtection() throws Exception
	{

		Human entity2 = new Human(11, "Dilbert", 50);
		Alien alien2 = new Alien("Commander Terrible", 100);
		
		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2,	4, entity2);
		theWorld.addLifeForm(3, 4, alien2);
		
		// alien damage is 10, mount attack calls takeHit()
		alien2.mountAttack(entity2);
		assertEquals(50, entity2.getLifePoints());
	}

	/*
	 * armor absorbs partial damage using takeHit() when damage > armor
	 */
	@Test
	public void testArmorProtectionPartial() throws Exception
	{
		Human entity = new Human(7, "Dilbert", 50);
		Alien alien = new Alien("Commander Terrible", 100);
		// alien damage is 10, mount attack calls takeHit()
		
		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2,	4, entity);
		theWorld.addLifeForm(3, 4, alien);
		
		alien.mountAttack(entity);
		assertEquals(47, entity.getLifePoints());

	}

	/*
	 * armor absorbs partial damage using takeHit() when damage > armor
	 */
	@Test
	public void testArmorProtectionSame() throws Exception
	{
		Human entity = new Human(10, "Dilbert", 50);
		Alien alien = new Alien("Commander Terrible", 100);
		
		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2,	4, entity);
		theWorld.addLifeForm(3, 4, alien);
		
		// alien damage is 10, mount attack calls takeHit()
		alien.mountAttack(entity);
		assertEquals(50, entity.getLifePoints());
	}

	/*
	 * armor absorbs all damage using takeHit() when damage < armor
	 */
	@Test
	public void testArmorProtectionBoundary1() throws Exception
	{
		Human entity = new Human(7, "Dilbert", 10);
		Alien alien = new Alien("Commander Terrible", 100);
		
		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2,	4, entity);
		theWorld.addLifeForm(3, 4, alien);
		
		alien.mountAttack(entity);
		alien.mountAttack(entity);
		alien.mountAttack(entity);
		alien.mountAttack(entity);
		alien.mountAttack(entity);
		alien.mountAttack(entity);
		assertEquals(0, entity.getLifePoints());
	}

	/*******************************************************************
	 * Start Section for Strategy Pattern Tests
	 * ******************************************************************
	 */

	/*
	 * getArmorPoints setArmorPoints values < 0 equal to 0
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
