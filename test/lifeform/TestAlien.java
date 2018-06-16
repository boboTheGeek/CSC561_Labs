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
import exceptions.RException;

public class TestAlien
{

	/**
	 * test that default attack str is 10
	 * 
	 * @throws RException
	 */
	@Test
	public void testDefaultAP() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40);
		assertEquals(10, alien.getAttackStrength());
	}
	
	/**
	 * set recovery rate in constructor
	 * 
	 * @throws RException
	 */
	@Test
	public void testRecoveryRate() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 4);
		assertEquals(4, alien.recoveryRate);
	}

	
	/**
	 * set recovery rate in setter
	 * 
	 * @throws RException
	 */
	@Test
	public void testRecoveryRateSetter() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 4);
		alien.setRecovery(2);
		assertEquals(2, alien.recoveryRate);
	}

	@Test //testing rate when set at 0
	public void testRecoveryRate0() throws RException
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
		assertEquals(1, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(2, alien.myTime);
		assertEquals(20, alien.getLifePoints());
	}


	@Test  //testing first valid recovery rate > 0
	public void testRecoveryRate2() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 2);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		
		assertEquals(0, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(1, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(2, alien.myTime);
		assertEquals(23, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(23, alien.getLifePoints());

		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(26, alien.getLifePoints());

	}
	
	@Test// testing 2 more recovery rates > 0
	public void testRecoveryRate3() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 3);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		
		//start by checking every third cycle
		assertEquals(0, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(1, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(2, alien.myTime);
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(23, alien.getLifePoints());

		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(23, alien.getLifePoints());
		
		///   here is the second recovery rate (every cycle)
		alien.setRecovery(1);
		alien.takeHit(3);
		assertEquals(20, alien.getLifePoints());
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(23, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		assertEquals(26, alien.getLifePoints());


	}
	
	
	//test when removed from being an observer (no recovery with time)
	@Test
	public void testRecoveryWhenNotObserver() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(1), 2);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		//check it's there
		assertEquals(alien, hiTimer.getObserver());
		hiTimer.removeTimeObserver(alien);

		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();

		assertEquals(20, alien.getLifePoints());

		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();

		assertEquals(20, alien.getLifePoints());

	}


	//throws exception if rate is < 0
	@SuppressWarnings("unused")
	@Test(expected = RException.class) // throws exception for negatives
	public void testRecoveryRateNegative() throws RException
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), -4);
		//assertEquals(4, alien.recoveryRate);
	}
	
	/**
	 * test that when Human attacks, it damages the Alien it's attacking
	 * 
	 * @throws RException
	 */
	@Test
	public void testMountAnAttack() throws RException
	{
		LifeForm human = new MockLifeForm("Sargent Snazzypants", 40, 5);
		Alien alien = new Alien("Commander Terrible", 40);
		human.mountAttack(alien);
		assertEquals(35, alien.getLifePoints());
	}
	
	
	/*******************************************************************
	 * Start Section for Strategy Pattern Tests
	 * ******************************************************************
	 */
	/**
	 * can initialize an alien
	 * 
	 * @throws RException
	 * 
	 */
	@Test
	public void testInitialize() throws RException
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
	public void testRecovery() throws RException
	{
		// test fractional recovery
		Alien entityFr = new Alien("Troy McClure", 150, new RecoveryFractional(10), 1);
		entityFr.updateTime(1);  //instance timer can't be 0 for recovery to work
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
	 * @throws RException
	 */
	@Test
	public void testSetLifePoints() throws RException
	{
		Alien entity2 = new Alien("2Pac McClure", 150);
		entity2.setCurrentLifePoints(200);
		assertEquals(200, entity2.currentLifePoints);
	}

	@Test
	public void testRecoveryNone() throws RException
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
