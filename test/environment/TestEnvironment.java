/**
 * Test cases for Environment class
 * @Author: Rob Miles
 */

package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestEnvironment
{
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
		Environment myEnvironment = new Environment(2, 3);

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
