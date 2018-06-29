/**
 * Test cases for LifeForm class
 * @Author: Rob Miles
 */

package lifeform;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.GenericWeapon;
import weapon.Pistol;
import weapon.Weapon;

/**
 * Tests the functionality provided by the LifeForm class
 *
 */
public class TestLifeForm
{
	
	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);
	}

	
	/**
	 * Stores life points Keeps track of name
	 */
	@Test
	public void testInitialization()
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getLifePoints());
		assertEquals("North", entity.getDirection());
		assertEquals(3, entity.maxSpeed);
	}
	
	//check that we can change the direction of our guy
	@Test
	public void testDirectionChange() throws RException
	{
		LifeForm entity = new MockLifeForm("Fluffy McDuff", 40, 5);
		assertEquals("North", entity.getDirection());
		entity.rotate("West");
		assertEquals("West", entity.getDirection());
	}

	/*
	 * *********************************** beginning of singleton lab
	 * **********************************
	 */

	@Test // testing pickup of weapon
	public void testGetWeapon()
	{
		LifeForm entity = new MockLifeForm("Fluffy McDuff", 40, 5);
		Weapon gunnyGunnerson = new MockShooter();
		entity.pickUpWeapon(gunnyGunnerson);
		assertEquals(gunnyGunnerson, entity.myWeapon);
	}

	@Test // doesn't pick up a second weapon if there is already on in present
	public void testCanNotPickup2()
	{
		LifeForm entity = new MockLifeForm("Fluffy McDuff", 40, 5);
		Weapon squirrelHunter = new MockShooter();
		Weapon secondShooter = new MockShooter();
		entity.pickUpWeapon(squirrelHunter);
		assertEquals(squirrelHunter, entity.myWeapon);
		entity.pickUpWeapon(secondShooter);
		assertEquals(squirrelHunter, entity.myWeapon);
	}

	@Test
	public void testDropWeapon()
	{
		LifeForm entity = new MockLifeForm("Fluffy McDuff", 40, 5);
		Weapon squirrelHunter = new MockShooter();
		entity.pickUpWeapon(squirrelHunter);
		assertEquals(squirrelHunter, entity.myWeapon);
		entity.dropWeapon();
		assertEquals(null, entity.myWeapon);
	}

	@Test // testing attack strength used when no weapon present
	public void testNoWeapon() throws EnvironmentException
	{
		LifeForm entity = new MockLifeForm("Hillbilly Bob", 40, 5);
		LifeForm entity2 = new MockLifeForm("Alien Fred", 30, 7);

		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2, 4, entity);
		theWorld.addLifeForm(3, 4, entity2);

		Weapon squirrelHunter = new MockShooter();

		entity.pickUpWeapon(squirrelHunter);
		assertEquals(squirrelHunter, entity.myWeapon);
		entity.dropWeapon();
		assertEquals(null, entity.myWeapon);
		// entity2 has 30 life points
		// entity has attack strength of 5
		// attacking without a weapon should mean 30 - 5
		entity.mountAttack(entity2);
		assertEquals(25, entity2.getLifePoints());

		entity.pickUpWeapon(squirrelHunter);
	}

	@Test // testing attack strength NOT used when out of range (distance > 10 feet)
	public void testAttackOutOfRange() throws EnvironmentException
	{
		LifeForm entity = new MockLifeForm("Hillbilly Bob", 40, 5);
		LifeForm entity2 = new MockLifeForm("Alien Fred", 30, 7);

		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(0, 0, entity);
		theWorld.addLifeForm(9, 9, entity2);

		// Range.distance = 13;
		// no damage should be done because it's greater than 10 feet to attack and
		// no weapon is present
		entity.mountAttack(entity2);
		assertEquals(30, entity2.getLifePoints());
	}

	@Test // testing attack strength used when no ammo left
	public void testNoAmmo() throws EnvironmentException
	{

		LifeForm entity = new MockLifeForm("Hillbilly Bob", 40, 5);
		LifeForm entity2 = new MockLifeForm("Alien Fred", 30, 7);

		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2, 4, entity);
		theWorld.addLifeForm(3, 4, entity2);

		Weapon gun = new Pistol();
		entity.pickUpWeapon(gun);
		for (int x = 0; x < 10; x++)
		{
			gun.damage(2);
			gun.update(1);
		}
		// entity2 has 30 life points
		// entity has attack strength of 5
		// attacking without a weapon should mean 30 - 5
		entity.mountAttack(entity2);
		assertEquals(25, entity2.getLifePoints());

	}

	@Test
	public void testReload()
	{
		LifeForm entity = new MockLifeForm("Alien Fred", 30, 7);
		Weapon squirrelHunter = new MockShooter();
		entity.pickUpWeapon(squirrelHunter);

		squirrelHunter.damage(1);
		squirrelHunter.damage(1);
		squirrelHunter.damage(1);// waste some shots

		assertEquals(7, squirrelHunter.getCurrentAmmo()); // check they're gone

		entity.reloadWeapon();
		assertEquals(10, entity.myWeapon.getCurrentAmmo());

	}

	@Test
	public void test2differentWeapons() throws EnvironmentException, RException
	{

		LifeForm entity = new MockLifeForm("Alien Fred", 30, 7);
		LifeForm entity2 = new MockLifeForm("Sargent Snazzypants", 40, 5);

		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2, 4, entity);
		theWorld.addLifeForm(1, 4, entity2);

		Weapon x = new Pistol();
		Weapon y = new ChainGun();
		entity.pickUpWeapon(x);
		entity.mountAttack(entity2);
		assertEquals(29, entity2.getLifePoints());
		entity.dropWeapon();
		entity.pickUpWeapon(y);
		entity.mountAttack(entity2);
		assertEquals(29, entity2.getLifePoints());

	}

	/*****************************************
	 * Start of lab 3 tests for Observer pattern*******************
	 */

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
	 * 
	 * @throws RException
	 * @throws EnvironmentException
	 */
	@Test
	public void testMountAnAttack() throws RException, EnvironmentException
	{
		LifeForm human = new MockLifeForm("Sargent Snazzypants", 40, 5);
		LifeForm alien = new MockLifeForm("Commander Terrible", 40, 10);

		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2, 4, human);
		theWorld.addLifeForm(3, 4, alien);

		human.mountAttack(alien);
		assertEquals(35, alien.getLifePoints());
	}

	/**
	 * test that a dead LifeForm can't attack
	 * 
	 * @throws EnvironmentException
	 * @throws RException
	 */
	@Test
	public void testMountAnAttackifDead() throws EnvironmentException, RException
	{
		LifeForm human = new MockLifeForm("Sargent Snazzypants", 20, 5);
		LifeForm alien = new MockLifeForm("Commander Terrible", 40, 10);

		Environment theWorld = Environment.getWorld();
		theWorld.addLifeForm(2, 4, human);
		theWorld.addLifeForm(3, 4, alien);

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

class MockShooter extends GenericWeapon
{

	MockShooter()
	{
		baseDamage = 10;
		maxRange = 20;
		rateOfFire = 3;
		maxAmmo = 10;
		currentTime = 0;
		currentAmmo = 10;
		shotCounter = 3;
	}

	/**
	 * Returns the amount of damage caused by the weapon at hand (pun intended :)
	 */
	@Override
	public int damageCalculation(int damage)
	{

		return baseDamage - 2;

	}

}
