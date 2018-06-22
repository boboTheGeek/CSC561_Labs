/**
 * Test cases for cell class
 * @Author: Rob Miles
 */

package environment;

import static org.junit.Assert.*;
import org.junit.Test;
import environment.Cell;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.Weapon;

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

	@SuppressWarnings("unused")
	@Test
	public void testAddWeapon() throws RException
	{
		Weapon pDog = new Pistol();
		Weapon cDog = new ChainGun();
		Weapon threeDog = new ChainGun();
		Cell cell = new Cell();
		cell.addWeapon(pDog);
		cell.addWeapon(cDog);
		//order matters here
		assertEquals(cDog, cell.getWeapon2());
		assertEquals(pDog, cell.getWeapon1());
	}

	@Test
	public void testRemoveWeapon() throws RException
	{
		Weapon pDog = new Pistol();
		Weapon cDog = new ChainGun();
		Cell cell = new Cell();
		assertNull(cell.getWeapon1());
		cell.addWeapon(pDog);
		cell.addWeapon(cDog);
		cell.removeWeapon(cDog);
		assertNull(cell.getWeapon2());
		cell.removeWeapon(pDog);
		assertNull(cell.getWeapon1());
		try // to remove a third weapon even if it's not there
		{
			cell.removeWeapon(pDog);
		}
		catch (RException e)
		{
			assertTrue(e instanceof RException);
		}

	}

	@Test // asserts that an RException is triggered when you try to add too many weapons
	public void testAdd3rdWeapon() throws RException
	{
		Weapon pDog = new Pistol();
		Weapon cDog = new ChainGun();
		Weapon threeDog = new ChainGun();
		Cell cell = new Cell();
		cell.addWeapon(pDog);
		cell.addWeapon(cDog);
		try
		{
			cell.addWeapon(threeDog);
		}
		catch (RException e)
		{
			assertTrue(e instanceof RException);
		}

	}

	/***********************************************************************
	 * Beginning of old tests lab 4 and before
	 * *************************************************************************
	 */

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
