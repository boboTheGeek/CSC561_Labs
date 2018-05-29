/**
 * Testing for alien class
 * 
 * @Author: Rob Miles
 */

package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;
import recovery.RecoveryFractional;
import recovery.RecoveryNone;

public class TestAlien
{

	/**
	 * can initialize an alien
	 */
	@Test
	public void testInitialize()
	{
		Alien entity = new Alien("Barnabus Rex", 200);
		assertEquals("Barnabus Rex", entity.getName());
		assertEquals(200, entity.getLifePoints());
	}

	/*
	 * recovery behavior interace can choose and utilize one of the recovery
	 * implementations
	 */
	@Test
	public void testRecovery()
	{
		// test fractional recovery
		Alien entityFr = new Alien("Troy McClure", 150, new RecoveryFractional(10));
		entityFr.setCurrentLifePoints(75);
		entityFr.recover();
		// 75 / 10 = 7.5 rounds up to 8
		// 8 + 75 = 83
		assertEquals(83, entityFr.getLifePoints());
	}

	/********************************
	 * Additional tests *******************************
	 * 
	 * test that we can set the life points
	 */
	@Test
	public void testSetLifePoints()
	{
		Alien entity2 = new Alien("2Pac McClure", 150);
		entity2.setCurrentLifePoints(200);
		assertEquals(200, entity2.currentLifePoints);
	}

	@Test
	public void testRecoveryNone()
	{
		// test no recovery
		Alien entityNR = new Alien("Troy McClure", 150, new RecoveryNone());
		assertEquals(150, entityNR.recoveryBehavior.calculateRecovery(150, 190));
	}

}
