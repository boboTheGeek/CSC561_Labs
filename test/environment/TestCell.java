/**
 * Test cases for cell class
 * @Author: Rob Miles
 */

package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Cell;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestCell
{

	/**
	 * At initialization, the Cell should be empty and not contain a LifeForm.
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

	/**
	 * Checks to see if we change the LifeForm held by the Cell that getLifeForm
	 * properly responds to this change.
	 */
	@Test
	public void testSetLifeForm()
	{
		MockLifeForm bob = new MockLifeForm("Bob", 40);
		MockLifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();

		// test that you can initialize and add LifeForm
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());

		// test that you can't add a LifeForm if one is Present
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());

		// test you can remove LifeForm
		LifeForm removedLF = cell.removeLifeForm();
		assertEquals(bob, removedLF);

		// test that it's cleared
		assertEquals(null, cell.getLifeForm());

		// test that it can handle removing from an empty cell
		assertEquals(null, cell.removeLifeForm());

	}

}
