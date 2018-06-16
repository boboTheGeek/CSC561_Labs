/**
 * Test  cases for Environment class
 * @Author: Rob Miles
 */

package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestEnvironment
{

	@Test // test initialization works as singleton
	public void testSigleton()
	{
		Environment.creatWorld(4, 5);
		Environment theWorld = Environment.getWorld();

	}

	@Test // test can clear the singleton from previous settings
	public void testClearWorld()
	{
	}

	@Test // test we can Add/Remove a weapon from a specific location
	public void testAddRemoveWeapon()
	{
		Weapon pewPewPew = new Pistol();

		Environment.creatWorld(4, 4);
		//Environment.theWorld.addWeapon(pewPewPew, 0, 0);
		

	}

	@Test // test we can determine range along the same row
	public void testDetermineRowDistance()
	{
	}

	@Test // test we can determine range along the same column
	public void testDetermineColumnDistance()
	{
	}

	@Test // test we can determine range from diagonal reference position
	public void testDetermineDiagonalDistance()
	{
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
	 */
	@Test
	public void makeBasicEnvt()
	{

		/*
		 * Create an Environment instance that consists of 2 rows and 3 columns.
		 */

		Environment.creatWorld(2, 3);
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
