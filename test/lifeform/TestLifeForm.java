/**
 * Test cases for LifeForm class
 * @Author: Rob Miles
 */

package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * Tests the functionality provided by the LifeForm class
 *
 */
public class TestLifeForm
{

	/**
	 * testing getAttackStrength returns present attack strength of the LifeForm
	 */
	@Test
	public void testGetSetAttack()
	{
		LifeForm entity = new MockLifeForm("Sargent Snazzypants", 40, 5);
		assertEquals(5, entity.getAttackStrength());
	}

	/**
	 * test that when one LifeForm attacks another, it damages the LifeForm it's
	 * attacking
	 */
	@Test
	public void testMountAnAttack()
	{
		LifeForm human = new MockLifeForm("Sargent Snazzypants", 40, 5);
		LifeForm alien = new MockLifeForm("Commander Terrible", 40, 10);
		human.mountAttack(alien);
		assertEquals(35, alien.getLifePoints());
	}

	/**
	 * test that a dead LifeForm can't attack
	 */
	@Test
	public void testMountAnAttackifDead()
	{
		LifeForm human = new MockLifeForm("Sargent Snazzypants", 20, 5);
		LifeForm alien = new MockLifeForm("Commander Terrible", 40, 10);
		alien.mountAttack(human);
		alien.mountAttack(human); // killing human first
		human.mountAttack(alien); // attemptint to illegally attack
		assertEquals(0, human.getLifePoints()); // ensure i'm dead
		assertEquals(40, alien.getLifePoints()); // no attack mounted
	}

	/*******************************************************************
	 * Start Section for Strategy Pattern Tests
	 * ******************************************************************
	 */

	/**
	 * Stores life points Keeps track of name
	 * 
	 * When a LifeForm is created, it should know its name and how many life points
	 * it has.
	 */
	@Test
	public void testInitialization()
	{
		LifeForm entity;
		entity = new LifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getLifePoints());
	}

	/**
	 * takeHit on first attack
	 * 
	 * Testing for takeHit method, note LifeForm cannot go below 0 life points
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm entity;
		entity = new LifeForm("Squidbert", 40);
		entity.takeHit(5);
		assertEquals(35, entity.getLifePoints());
	}

	/**
	 * takeHit after first attack when 0<currentLP take hit when LP is at could go
	 * below 0
	 * 
	 * Testing for takeHit method, note LifeForm cannot go below 0 life points
	 */
	@Test
	public void testTakeHitMulitple()
	{
		LifeForm entity;
		entity = new LifeForm("Mr. Punching Bag", 30);
		// inital hit
		entity.takeHit(10);
		assertEquals(20, entity.getLifePoints());

		// **** second hit, still > 0
		entity.takeHit(15);
		assertEquals(5, entity.getLifePoints());
		// another hit would go below 0
		entity.takeHit(15);
		assertEquals(0, entity.getLifePoints());

		// **** one hit when LP is already 0
		entity.takeHit(15);
		assertEquals(0, entity.getLifePoints());

	}

}


