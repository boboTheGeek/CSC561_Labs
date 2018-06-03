/**
 * Testing for alien class
 * 
 * @Author: Rob Miles
 */

package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;

import gameplay.SimpleTimer;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

public class TestAlien
{

	/**
	 * test that default attack is set to 10
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDefaultAP() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40);
		assertEquals(10, alien.getAttackStrength());
	}

	/**
	 * test that when Human attacks, it damages the Alien it's attacking
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMountAnAttack() throws Exception
	{
		LifeForm human = new MockLifeForm("Sargent Snazzypants", 40, 5);
		Alien alien = new Alien("Commander Terrible", 40);
		human.mountAttack(alien);
		assertEquals(35, alien.getLifePoints());
	}

	/**
	 * test recovery time setting
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRecoveryRate() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 4);
		assertEquals(4, alien.recoveryRate);
	}

	@Test(expected = Exception.class) // throws exception for negatives
	public void testRecoveryRateNegative() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), -4);
		assertEquals(4, alien.recoveryRate);
	}

	@Test
	public void testRecoveryRate2() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 2);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		
		assertEquals(0, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(1, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(2, alien.myTime);
		assertEquals(23, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(23, alien.getLifePoints());

		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(26, alien.getLifePoints());

	}
	
	@Test
	public void testRecoveryRate3() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 3);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		
		assertEquals(0, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(1, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(2, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(23, alien.getLifePoints());

		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(23, alien.getLifePoints());

	}
	
	@Test
	public void testRecoveryRate0() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 0);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		
		assertEquals(0, alien.myTime);
		assertEquals(0, alien.recoveryRate);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(1, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(2, alien.myTime);
		assertEquals(20, alien.getLifePoints());
	}
	/*******************************************************************
	 * Start Section for Strategy Pattern Tests
	 * ******************************************************************
	 */
	/**
	 * can initialize an alien
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testInitialize() throws Exception
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
	public void testRecovery() throws Exception
	{
		// test fractional recovery
		Alien entityFr = new Alien("Troy McClure", 150, new RecoveryFractional(10), 1);
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
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetLifePoints() throws Exception
	{
		Alien entity2 = new Alien("2Pac McClure", 150);
		entity2.setCurrentLifePoints(200);
		assertEquals(200, entity2.currentLifePoints);
	}

	@Test
	public void testRecoveryNone() throws Exception
	{
		// test no recovery
		Alien entityNR = new Alien("Troy McClure", 150, new RecoveryNone(), 0);
		assertEquals(150, entityNR.recoveryBehavior.calculateRecovery(150, 190));
	}

}

class MockSimpleTimer extends SimpleTimer
{
	// @Override
	public void overrideIncrementCurrentTime()
	{
		currentTime++;
	}
}
