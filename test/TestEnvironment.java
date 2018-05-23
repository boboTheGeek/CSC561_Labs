import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnvironment
{
	/**
	 * 
	 *  
	 * 
	 */
	@Test
	public void makeBasicEnvt()
	{

		/* 
		 *  1. Create an Environment instance that consists of 2 rows and 3 columns.
		 */
		Environment myEnvironment = new Environment(2, 3);

		/*
		 *  2. Create a LifeForm instance to store in the Environment.
		 */
		LifeForm jill = new LifeForm("Jill", 41);


		/*
		 *  3. Add the LifeForm instance to row 1 and column 2 of the Environment instance. 
		 */
		myEnvironment.addLifeForm(1, 2, jill);

		/*
		 *  4. Check that the Environment is now holding LifeForm instance.
		 */
		assertEquals(jill, myEnvironment.getCell(1, 2).getLifeForm());

	}

}
