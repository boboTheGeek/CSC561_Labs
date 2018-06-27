/**
 * Test  cases for Environment class
 * @Author: Rob Miles
 */

package environment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestEnvironment
{

	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);
	}

	@Test
	public void testTurning() throws RException
	{
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("billy", 20, 20);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		theWorld.playerDirection("West");
		assertEquals("West", entity.getDirection());
		theWorld.playerDirection("South");
		assertEquals("South", entity.getDirection());
		theWorld.playerDirection("East");
		assertEquals("East", entity.getDirection());
		theWorld.playerDirection("East");
		assertEquals("East", entity.getDirection());
		try
		{
			theWorld.playerDirection("Home");
		} catch (RException e)
		{
			assertTrue(e instanceof RException);
		}
	}
	
	@Test
	public void testMovement() throws RException
	{
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bobbySue", 20, 20);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		theWorld.movePlayer();
		int[] y = theWorld.getLifeFormLocation(entity);
		assertEquals(2, y[0]);
		theWorld.playerDirection("South");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(5, y[0]);
		theWorld.playerDirection("East");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(8, y[1]);
		theWorld.playerDirection("West");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(5, y[1]);
	}
	
	@Test  //checking that the player stays within the bounds defined by the size of the cell grid
	public void testMovementBoundaries() throws RException
	{
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bobbySue", 20, 20);
		theWorld.addLifeForm(1, 1, entity);
		theWorld.setActivePlayer(entity);
		theWorld.movePlayer();
		int[] y = theWorld.getLifeFormLocation(entity);
		assertEquals(0, y[0]);
		theWorld.playerDirection("West");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(0, y[1]);
		theWorld.removeLifeForm(0, 0);
		theWorld.addLifeForm(9, 9, entity);
		theWorld.playerDirection("East");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(10, y[1]);
		theWorld.playerDirection("South");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(10, y[1]);
	}
	
	@Test
	public void testSomeoneIsInMySpot() throws RException
	{
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("Rudolph Flowerbottom", 20, 20);
		LifeForm entity2 = new MockLifeForm("Lennard Kensington", 20, 20);
		LifeForm entity3 = new MockLifeForm("Rodney Chesterfield", 20, 20);
		theWorld.addLifeForm(1, 1, entity);
		theWorld.addLifeForm(4, 1, entity2);
		theWorld.addLifeForm(3, 1, entity3);
		theWorld.setActivePlayer(entity);
		theWorld.playerDirection("South");
		theWorld.movePlayer();
		int[] y = theWorld.getLifeFormLocation(entity);
		assertEquals(2, y[0]);
		theWorld.playerDirection("East");
		theWorld.addLifeForm(2, 4, entity2);
		theWorld.addLifeForm(2, 3, entity3);
		y = theWorld.getLifeFormLocation(entity);
		theWorld.movePlayer();
		assertEquals(2, y[1]);
		theWorld.addLifeForm(9, 9, entity);
		theWorld.addLifeForm(9, 6, entity3);
		theWorld.playerDirection("West");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(7, y[1]);

		theWorld.addLifeForm(6, 7, entity3);
		theWorld.addLifeForm(8, 7, entity2);
		theWorld.playerDirection("North");
		theWorld.movePlayer();
		y = theWorld.getLifeFormLocation(entity);
		assertEquals(7, y[0]);
	}
	
	
	/**
	 * ***************************************************** start of singleton lab
	 * #5 **************************************
	 */

	@Test // test initialization works as singleton
	public void testSigleton() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(4, 5);
		Environment theWorld = Environment.getWorld();
		assertTrue(theWorld instanceof Environment);

		// check that it's working as a singleton
		// throws an exception if fails
		try
		{
			Environment.createWorld(2, 2);
		} catch (RException e)
		{
			assertTrue(e instanceof RException);
		}
	}

	@Test // test can clear the singleton from previous settings
	public void testClearWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(4, 5);
		Environment.resetWorld();
		assertNull(Environment.getWorld());
	}

	@Test // test we can Add/Remove a weapon from a specific location
	public void testAddRemoveWeapon() throws RException
	{
		Environment.resetWorld();
		Weapon pewPewPew = new Pistol();
		Weapon pewPewPew2 = new Pistol();
		Environment.createWorld(10, 10);
		Environment theWorld = Environment.getWorld();
		theWorld.addWeapon(2, 2, pewPewPew);
		theWorld.addWeapon(2, 2, pewPewPew2);
		assertEquals(pewPewPew, theWorld.getWeapon(2, 2, 1));
		assertEquals(pewPewPew2, theWorld.getWeapon(2, 2, 2));
		theWorld.removeWeaponByCell(2, 2);
		theWorld.removeWeaponByCell(2, 2);
		assertNull(theWorld.getWeapon(2, 2));

	}

	@Test // test we can determine range along the same row
	public void testDetermineRowDistance() throws RException, EnvironmentException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);
		Environment theWorld = Environment.getWorld();
		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		theWorld.addLifeForm(0, 2, anna);
		theWorld.addLifeForm(2, 2, elsa);
		assertEquals(20.0, theWorld.getRange(anna, elsa), 0.1);
	}

	@Test // test we can determine range along the same column
	public void testDetermineColumnDistance() throws RException, EnvironmentException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);
		Environment theWorld = Environment.getWorld();

		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		theWorld.addLifeForm(2, 4, anna);
		theWorld.addLifeForm(2, 2, elsa);
		assertEquals(20.0, theWorld.getRange(anna, elsa), 0.1);
	}

	@Test // test we can determine range from diagonal reference position
	public void testDetermineDiagonalDistance() throws RException, EnvironmentException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);
		Environment theWorld = Environment.getWorld();

		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		theWorld.addLifeForm(2, 4, anna);
		theWorld.addLifeForm(6, 8, elsa);
		//

		assertEquals(56.5f, theWorld.getRange(anna, elsa), 0.1);
	}

	@Test // test that it handles distance computation exception when one entity is
			// missing
	public void testDetermineColumnDistanceException() throws RException, EnvironmentException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);
		Environment theWorld = Environment.getWorld();

		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		theWorld.addLifeForm(2, 4, anna);
		// elsa is missing from the world but is still a valid person!!!!!!!

		try
		{
			theWorld.getRange(anna, elsa);
		} catch (EnvironmentException e)
		{
			assertTrue(e instanceof EnvironmentException);
		}
	}

	/****************************************************************************
	 * Old tests from previous labs start here
	 * ****************************************************************************
	 * 
	 * 
	 */
	/**
	 * Test a basic positive case instantiating an Environment and populating a cell
	 * with a LifeForm
	 * 
	 * @throws RException
	 */
	@Test
	public void makeBasicEnvt() throws RException
	{

		/*
		 * Create an Environment instance that consists of 2 rows and 3 columns.
		 */
		Environment.resetWorld();
		Environment.createWorld(2, 3);
		Environment myEnvironment = Environment.getWorld();

		/*
		 * Create and add LifeForm instance to store in the Environment.
		 */
		MockLifeForm jill = new MockLifeForm("Jill", 41);
		myEnvironment.addLifeForm(1, 2, jill);

		/*
		 * Check that the Environment is now holding LifeForm instance.
		 */
		assertEquals(jill, myEnvironment.getLifeForm(1, 2));

		/*
		 * test that you can't add a value to an already populated cell
		 */
		MockLifeForm edna = new MockLifeForm("Edna", 100);
		assertFalse(myEnvironment.addLifeForm(1, 2, edna));

		/*
		 * test for adding item out of bounds location 5, 7 doesn't exist
		 */
		assertFalse(myEnvironment.addLifeForm(5, 7, jill));

		/*
		 * test that we can remove a LifeForm from a cell
		 */
		LifeForm removeMe = myEnvironment.removeLifeForm(1, 2);
		assertEquals(jill, removeMe);

		/*
		 * test we can handle if we try to remove LifeForm from a blank cell
		 */
		assertEquals(null, myEnvironment.removeLifeForm(1, 2));

		/*
		 * test we can handle if we try to get from a blank cell
		 */
		assertEquals(null, myEnvironment.getLifeForm(1, 2));

	}

}
