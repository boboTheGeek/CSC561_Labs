/**
 * This class sets up the environment with a 2D array of cells 
 * 
 * @Author: Rob Miles
 */

package environment;

import java.util.HashMap;

import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;
import weapon.Weapon;

public class Environment
{

	private static Environment theWorld;
	private Cell[][] cells;
	private int numrows;
	private int numcols;
	private HashMap<LifeForm, int[]> entityLocations = new HashMap<>();
	private HashMap<Weapon, int[]> weaponLocations = new HashMap<>();
	public static LifeForm itsMyTurn;

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
	 * @throws RException
	 */
	public static void createWorld(int rows, int cols) throws RException
	{
		if (theWorld == null)
		{
			theWorld = new Environment(rows, cols);
		}
		else
		{
			throw new RException("your world is already created");
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

	public static void resetWorld()
	{
		theWorld = null;
		// clear the arrays

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
			loc[1] = col;
			entityLocations.put(entity, loc);
			return true;
		}
		else
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
		}
		else
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
	public LifeForm removeLifeForm(int row, int col)
	{
		if (cells[row][col] != null)
		{
			LifeForm removeMe = cells[row][col].getLifeForm();
			cells[row][col] = null;
			entityLocations.remove(removeMe);
			return removeMe;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Adds a Weapon to the Cell theCells[row][col]. Will not add the Weapon if the
	 * row and col are invalid or if a Weapon is already in that Cell. Returns true
	 * if successfully added, false otherwise.n
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
		if (row <= numrows && col <= numcols)
		{
			Cell containerCell = new Cell();
			containerCell.addWeapon(weapon);
			cells[row][col] = containerCell;
			int[] loc = new int[2];
			loc[0] = row;
			loc[1] = col;
			weaponLocations.put(weapon, loc);
			return true;
		}
		else
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
	public Weapon getWeapon(int row, int col) throws RException
	{
		if (cells[row][col] != null)
		{
			return cells[row][col].getWeapon();
		}
		else
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
	public Weapon removeWeaponByCell(int row, int col) throws RException
	{
		if (cells[row][col] != null)
		{
			Weapon removeMe = cells[row][col].getWeapon();
			cells[row][col] = null;
			weaponLocations.remove(removeMe);
			return removeMe;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Calculate the distance from one entity to the other based on their cell
	 * locations. Will be used when they are attacking each other.
	 * 
	 * @param entity1
	 * @param entity2
	 * @return the distance (in feet)
	 * @throws EnvironmentException
	 */
	public double getRange(LifeForm entity1, LifeForm entity2) throws EnvironmentException
	{
		if ((entityLocations.get(entity1) == null) || (entityLocations.get(entity2) == null))
		{
			throw new EnvironmentException(
					"you need 2 (emphasis on the number 2) entitys to figure out the distance between 2 entities");
		}
		else
		{
			int[] l1 = entityLocations.get(entity1);
			int[] l2 = entityLocations.get(entity2);
			int rDelta = l2[0] - l1[0];
			int cDelta = l2[1] - l1[1];
			rDelta = rDelta * rDelta;
			cDelta = cDelta * cDelta;
			double distance = Math.sqrt(rDelta + cDelta);
			return distance * 10; // each cell is 10 feet by 10 feet
		}

	}

	/**
	 * sends back the location of which cell someone is in
	 * 
	 * @param lf
	 *            who we want to locate
	 * @return the array of where they're located row, column
	 */

	public int[] getLifeFormLocation(LifeForm lf)
	{
		return entityLocations.get(lf);
	}

	/**
	 * changes the direction of the entity who's turn it is (itsMyTurn) to the
	 * string passed
	 * 
	 * @throws RException
	 * 
	 */

	public void playerDirection(String heading) throws RException
	{
		itsMyTurn.rotate(heading);
	}

	/**
	 * sets the LifeForm who's turn it currently is. This is the active player who
	 * will be making the moves
	 * 
	 * @param entity
	 *            is whoever's turn it is
	 */
	public void setActivePlayer(LifeForm entity)
	{
		itsMyTurn = entity;
	}

	/**
	 * moves the active player in the direction they are facing. moves them the
	 * maximum amount they are allowed
	 * 
	 * @return
	 */
	public void movePlayer()
	{
		int speed = itsMyTurn.getSpeed();
		int[] actualLocation = getLifeFormLocation(itsMyTurn);
		int[] proposedLocation = actualLocation;
		if (itsMyTurn.getDirection() == "North")
		{
			proposedLocation[0] = actualLocation[0] - speed;
			while (someoneInMySpot(proposedLocation) == true)
			{
				proposedLocation[0]++;
			}
		}
		else if (itsMyTurn.getDirection() == "South")
		{
			proposedLocation[0] = actualLocation[0] + speed;
			while (someoneInMySpot(proposedLocation) == true)
			{
				proposedLocation[0]--;
			}
		}
		else if (itsMyTurn.getDirection() == "West")
		{
			proposedLocation[1] = actualLocation[1] - speed;
			while (someoneInMySpot(proposedLocation) == true)
			{
				proposedLocation[1]++;
			}
		}
		else if (itsMyTurn.getDirection() == "East")
		{
			proposedLocation[1] = actualLocation[1] + speed;
			while (someoneInMySpot(proposedLocation) == true)
			{
				proposedLocation[1]--;
			}
		}
		int[] intermediateLocation = assessMovementBoundaries(proposedLocation);
		// int[] finalLocation = areYouInMySpot(intermediateLocation);
		entityLocations.put(itsMyTurn, intermediateLocation);
	}

	private int[] assessMovementBoundaries(int[] propLoc)
	{
		int[] newProposal = propLoc;
		if (propLoc[0] < 0)
		{
			newProposal[0] = 0;
		}
		else if (propLoc[1] < 0)
		{
			newProposal[1] = 0;
		}
		else if (propLoc[0] > numrows)
		{
			newProposal[0] = numrows;
		}
		else if (propLoc[1] > numcols)
		{
			newProposal[1] = numcols;
		}
		return newProposal;
	}

	private boolean someoneInMySpot(int[] interLoc)
	{
		int numConflicts = 0;
		for (int[] value : entityLocations.values())
		{
			if ((value[0] == interLoc[0]) && (value[1] == interLoc[1]))
			{
				numConflicts++;
			}

		}
		if (numConflicts > 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * returns the dimensions of the Environment "theWorld"
	 * 
	 * @return array of size int[0] = rows, int[1] = columns
	 */
	public int[] getEnvironmentDimensions()
	{

		int[] dim =
		{ numrows, numcols };
		return dim;

	}

}