/**
 * This class sets up the environment with a 2D array of cells 
 * 
 * @Author: Rob Miles
 */

package environment;

import java.util.HashMap;

import lifeform.LifeForm;
import weapon.Weapon;

public class Environment
{

	public static Environment theWorld;
	private Cell[][] cells;
	private int numrows;
	private int numcols;
	private HashMap<LifeForm, Cell> entityLocations = new HashMap<>();
	private HashMap<Weapon, Cell> weaponLocations = new HashMap<>();

	/**
	 * Initialize environment instance with specified 2D dimensions
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

	public static void creatWorld(int rows, int cols)
	{
		if (theWorld == null)
		{
			theWorld = new Environment(rows, cols);
		}

	}
	
	public static Environment getWorld()
	{

		return theWorld;
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
	 * @return true or false depending on whether the life form was succesfully
	 *         added
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row <= numrows && col <= numcols && cells[row][col] == null)
		{
			Cell containerCell = new Cell();
			containerCell.addLifeForm(entity);
			cells[row][col] = containerCell;
			entityLocations.put(entity, containerCell);
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

	public void addWeapon(Weapon wep, int row, int col)
	{
		
		weaponLocations.put(wep, cells[row][col]);
		
	}



}