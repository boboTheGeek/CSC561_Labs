import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnvironment
{
	/**
	 * 
	 *  Test a basic positive case instantiating an Environment 
	 *  and populating a cell with a LifeForm
	 * 
	 */
	@Test
	public void makeBasicEnvt()
	{

		/*
		 * 1. Create an Environment instance that consists of 2 rows and 3 columns.
		 */
		Environment myEnvironment = new Environment(2, 3);

		/*
		 * 2. Create a LifeForm instance to store in the Environment.
		 */
		LifeForm jill = new LifeForm("Jill", 41);

		/*
		 * 3. Add the LifeForm instance to row 1 and column 2 of the Environment
		 * instance.
		 */
		myEnvironment.addLifeForm(1, 2, jill);

		/*
		 * 4. Check that the Environment is now holding LifeForm instance.
		 */
		assertEquals(jill, myEnvironment.getCell(1, 2));

		/*
		 * test that you can't add a value to an already populated cell
		 */
		LifeForm edna = new LifeForm("Edna", 100);
		assertFalse(myEnvironment.addLifeForm(1, 2, edna));

		/*
		 * test that we can remove a LifeForm from a cell
		 */
		LifeForm removeMe = myEnvironment.removeLifeForm(1, 2);
		assertEquals(jill, removeMe);

	}


}
