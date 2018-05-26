/**
 * Testing for alien class
 * 
 * Author: Rob Miles
 */

package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

import recovery.RecoveryLinear;
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
		assertEquals(200, entity.getCurrentLifePoints());
	}

	/*
	 * recovery behavior interace can choose and utilize one of the recovery
	 * implementations
	 */
	@Test
	public void testRecovery()
	{
		// test linear recovery
		Alien entity2 = new Alien("2Pac McClure", 150, new RecoveryLinear(3));
		//probably need to change this to pull instance variables for current life and max life
		//  here we're manually setting them
		assertEquals(153, entity2.recoveryBehavior.calculateRecovery(150, 190));
	}

	/**
	 * test that we can set the life points
	 */
	@Test
	public void testSetLifePoints()
	{
		Alien entity2 = new Alien("2Pac McClure", 150);
		entity2.setCurrentLifePoints(200);
		assertEquals(200, entity2.currentLifePoints);

	}

	/**
	 * Additional Test Cases
	 * 
	 * 
	 */
	@Test
	public void testRecoveryNone()
	{

		// test no recovery
		Alien entityNR = new Alien("Troy McClure", 150, new RecoveryNone());
		assertEquals(150, entityNR.recoveryBehavior.calculateRecovery(150, 190));
	}



}
