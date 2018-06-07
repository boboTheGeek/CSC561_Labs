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
	 * test that default attack str is 10
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
	 * set recovery rate in constructor
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRecoveryRate() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 4);
		assertEquals(4, alien.recoveryRate);
	}

	
	/**
	 * set recovery rate in setter
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRecoveryRateSetter() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 4);
		alien.setRecovery(2);
		assertEquals(2, alien.recoveryRate);
	}

	@Test //testing rate when set at 0
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


	@Test  //testing first valid recovery rate
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
	
	@Test// testing 2 more recovery rates > 0
	public void testRecoveryRate3() throws Exception
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
		
		///   here is the second recovery rate (every cycle)
		alien.setRecovery(1);
		alien.takeHit(3);
		assertEquals(20, alien.getLifePoints());
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(23, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(26, alien.getLifePoints());


	}
	
	
	//test when removed from being an observer (no recovery with time)
	@Test
	public void testRecoveryWhenNotObserver() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), 1);
		alien.takeHit(20);

		MockSimpleTimer hiTimer = new MockSimpleTimer();
		hiTimer.addTimeObserver(alien);
		//check it's there
		assertEquals(alien, hiTimer.getObserver());
		hiTimer.removeTimeObserver(alien);
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(20, alien.getLifePoints());
		
		hiTimer.overrideIncrementCurrentTime();
		hiTimer.timeChanged();
		alien.recover();
		assertEquals(20, alien.getLifePoints());
		
	}


	//throws exception if rate is < 0
	@Test(expected = Exception.class) // throws exception for negatives
	public void testRecoveryRateNegative() throws Exception
	{
		Alien alien = new Alien("Commander Terrible", 40, new RecoveryLinear(3), -4);
		assertEquals(4, alien.recoveryRate);
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
