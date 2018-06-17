/**
 * Test  cases for Environment class
 * @Author: Rob Miles
 */

package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestEnvironment
{

	@Test // test initialization works as singleton
	public void testSigleton()
	{
		Environment.createWorld(4, 5);
		Environment theWorld = Environment.getWorld();
		assertTrue(Environment.theWorld instanceof Environment);
	}

	@Test // test can clear the singleton from previous settings
	public void testClearWorld()
	{
	}

	@Test // test we can Add/Remove a weapon from a specific location
	public void testAddRemoveWeapon() throws RException
	{
		Environment.resetWorld();
		Weapon pewPewPew = new Pistol();

		Environment.createWorld(10, 10);
		Environment.theWorld.addWeapon(2, 2, pewPewPew);
		assertEquals(pewPewPew, Environment.theWorld.getWeapon(2, 2, pewPewPew));
		Environment.theWorld.removeWeaponByCell(2, 2, pewPewPew);
		assertNull(Environment.theWorld.getWeapon(2, 2, pewPewPew));

	}

	@Test // test we can determine range along the same row
	public void testDetermineRowDistance()
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);

		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		Environment.theWorld.addLifeForm(0, 2, anna);
		Environment.theWorld.addLifeForm(2, 2, elsa);
		assertEquals(2.0, Environment.theWorld.getRange(anna, elsa), 0.1);
	}

	@Test // test we can determine range along the same column
	public void testDetermineColumnDistance()
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);

		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		Environment.theWorld.addLifeForm(2, 4, anna);
		Environment.theWorld.addLifeForm(2, 2, elsa);
		assertEquals(2.0, Environment.theWorld.getRange(anna, elsa), 0.1);
	}

	@Test // test we can determine range from diagonal reference position
	public void testDetermineDiagonalDistance()
	{
		Environment.resetWorld();
		Environment.createWorld(10, 10);

		LifeForm anna = new MockLifeForm("anna", 50);
		LifeForm elsa = new MockLifeForm("elsa", 50);

		Environment.theWorld.addLifeForm(2, 4, anna);
		Environment.theWorld.addLifeForm(6, 8, elsa);
		//

		assertEquals(5.6f, Environment.theWorld.getRange(anna, elsa), 0.1);
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
		LifeForm removeMe = myEnvironment.removeLifeFormByCell(1, 2);
		assertEquals(jill, removeMe);

		/*
		 * test we can handle if we try to remove LifeForm from a blank cell
		 */
		assertEquals(null, myEnvironment.removeLifeFormByCell(1, 2));

		/*
		 * test we can handle if we try to get from a blank cell
		 */
		assertEquals(null, myEnvironment.getLifeForm(1, 2));

	}

}
