/**
 * This class sets up the environment with a 2D array of cells 
 * 
 * @Author: Rob Miles
 */

package environment;

import java.util.HashMap;

import exceptions.RException;
import lifeform.LifeForm;
import weapon.Weapon;

public class Environment
{

	public static Environment theWorld;
	private Cell[][] cells;
	private int numrows;
	private int numcols;
	private HashMap<LifeForm, int[]> entityLocations = new HashMap<>();
	private HashMap<Weapon, int[]> weaponLocations = new HashMap<>();

	/**
	 * Initialize environment instance with specified 2D dimensions. Made to be
	 * private constructor to enforce singleton pattern (so only one "theWorld" can
	 * be instantiated)
	 * 
	 * @param rows
	 *            - the number of rows in the 2D environment array
	 * 
	 * @param cols
	 *            - the number of columns in the 2D environment array
	 */
	private Environment(int rows, int cols)
	{

		cells = new Cell[rows][cols];
		numrows = rows;
		numcols = cols;

	}

	/**
	 * Creates the singleton theWorld object. Public static method is visible
	 * publicly and can only create one copy of "theWorld" instance.
	 * 
	 * @param rows
	 *            - how many rows of cells the environment will have
	 * @param cols
	 *            - how many columns of cells the environment of the world will
	 *            have.
	 */
	public static void createWorld(int rows, int cols)
	{
		if (theWorld == null)
		{
			theWorld = new Environment(rows, cols);
		}
	}

	/**
	 * public static method to simply access the singleton instance of theWorld
	 * 
	 * @return - THE copy of theWorld singleton instance
	 */
	public static Environment getWorld()
	{

		return theWorld;
	}
	
	public static void resetWorld() {
		theWorld = null;
		//clear the arrays
		
	}

	/**
	 * Adds a LifeForm to the Cell theCells[row][col]. Will not add the LifeForm if
	 * the row and col are invalid or if a LifeForm is already in that Cell. Returns
	 * true if successfully added, false otherwise.n
	 * 
	 * @param row
	 *            - the row address of the 2D array
	 * 
	 * @param col
	 *            - the column address of the 2D array
	 * 
	 * @param cell
	 *            - the cell object that you want to put in that "table" location
	 * 
	 * @return true or false depending on whether the life form was successfully
	 *         added
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row <= numrows && col <= numcols && cells[row][col] == null)
		{
			Cell containerCell = new Cell();
			containerCell.addLifeForm(entity);
			cells[row][col] = containerCell;
			int[] loc = new int[2];
			loc[0] = row;
			loc[0] = col;
			entityLocations.put(entity, loc);
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * return the LifeForm from a particular x,y location in 2D environment array
	 * 
	 * @param row
	 *            - row coordinate from 2D environment array
	 * 
	 * @param col
	 *            - column coordinate from 2D environment array
	 * 
	 * @return requested LifeForm (null if empty)
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		if (cells[row][col] != null)
		{
			return cells[row][col].getLifeForm();
		} else
		{
			return null;
		}
	}

	/**
	 * Removes the LifeForm at theCells[row][col]. Returns the LifeForm removed
	 * (null if no LifeForm in the Cell).
	 * 
	 * @param row
	 *            - row coordinate from 2D environment array
	 * 
	 * @param col
	 *            - column coordinate from 2D environment array
	 * 
	 * @return life form removed else null
	 */
	public LifeForm removeLifeFormByCell(int row, int col)
	{
		if (cells[row][col] != null)
		{
			LifeForm removeMe = cells[row][col].getLifeForm();
			cells[row][col] = null;
			entityLocations.remove(removeMe);
			return removeMe;
		} else
		{
			return null;
		}
	}

	/**
	 * Removes the LifeForm at theCells[row][col]. Returns the LifeForm removed
	 * (null if no LifeForm in the Cell).
	 * 
	 * @param row
	 *            - row coordinate from 2D environment array
	 * 
	 * @param col
	 *            - column coordinate from 2D environment array
	 * 
	 * @return life form removed else null
	 * @throws RException
	 */
//	public LifeForm removeLifeForm(LifeForm entity) throws RException
//	{
//		;
//		if (entityLocations.get(entity) != null)
//		{
//			System.out.println(entityLocations.get(entity));
//			entityLocations.get(entity).removeLifeForm();
//			// LifeForm removeMe = cells[row][col].getLifeForm();
//			// cells[row][col] = null;
//			// entityLocations.remove(removeMe);
//			return null;
//		} else
//		{
//			throw new RException("there is no one by this name to remove");
//		}
//	}

	/**
	 * Adds a Weapon to the Cell theCells[row][col]. Will not add the Weapon if
	 * the row and col are invalid or if a Weapon is already in that Cell. Returns
	 * true if successfully added, false otherwise.n
	 * 
	 * @param row
	 *            - the row address of the 2D array
	 * 
	 * @param col
	 *            - the column address of the 2D array
	 * 
	 * @param cell
	 *            - the cell object that you want to put in that "table" location
	 * 
	 * @return true or false depending on whether the life form was successfully
	 *         added
	 * @throws RException 
	 */
	public boolean addWeapon(int row, int col, Weapon weapon) throws RException
	{
		if (row <= numrows && col <= numcols && cells[row][col] == null)
		{
			Cell containerCell = new Cell();
			containerCell.addWeapon(weapon);
			cells[row][col] = containerCell;
			int[] loc = new int[2];
			loc[0] = row;
			loc[0] = col;
			weaponLocations.put(weapon, loc);
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * return the LifeForm from a particular x,y location in 2D environment array
	 * 
	 * @param row
	 *            - row coordinate from 2D environment array
	 * 
	 * @param col
	 *            - column coordinate from 2D environment array
	 * 
	 * @return requested LifeForm (null if empty)
	 * @throws RException 
	 */
	public Weapon getWeapon(int row, int col, Weapon weapon) throws RException
	{
		if (cells[row][col] != null)
		{
			return cells[row][col].getWeapon(weapon);
		} else
		{
			return null;
		}
	}

	/**
	 * Removes the LifeForm at theCells[row][col]. Returns the LifeForm removed
	 * (null if no LifeForm in the Cell).
	 * 
	 * @param row
	 *            - row coordinate from 2D environment array
	 * 
	 * @param col
	 *            - column coordinate from 2D environment array
	 * 
	 * @return life form removed else null
	 * @throws RException 
	 */
	public Weapon removeWeaponByCell(int row, int col, Weapon weapon) throws RException
	{
		if (cells[row][col] != null)
		{
			Weapon removeMe = cells[row][col].getWeapon(weapon);
			cells[row][col] = null;
			weaponLocations.remove(removeMe);
			return removeMe;
		} else
		{
			return null;
		}
	}

}