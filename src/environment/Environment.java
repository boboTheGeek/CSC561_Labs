/**
 * This class sets up the environment with a 2D array of cells 
 * 
 * @Author: Rob Miles
 */

package environment;

import java.util.Arrays;
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
		if (row < numrows && col < numcols)
		{
			if (cells[row][col] == null)
			{
				Cell containerCell = new Cell();
				containerCell.addLifeForm(entity);
				cells[row][col] = containerCell;
				int[] loc = { row, col };
				getEntityLocations().put(entity, loc);
				return true;
			}
			else if (cells[row][col].getLifeForm() == null)
			{
				cells[row][col].addLifeForm(entity);
				int[] loc = { row, col };
				getEntityLocations().put(entity, loc);
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return false;
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
			cells[row][col].removeLifeForm();
			getEntityLocations().remove(removeMe);
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
	 * @return true or false depending on whether the weapon was successfully added
	 * @throws RException
	 */
	public boolean addWeapon(int row, int col, Weapon weapon) throws RException
	{
		if (row <= numrows && col <= numcols)
		{
			if (cells[row][col] == null)
			{
				Cell containerCell = new Cell();
				containerCell.addWeapon(weapon);
				cells[row][col] = containerCell;
			}
			else
			{
				cells[row][col].addWeapon(weapon);
			}
			int[] loc = new int[2];
			loc[0] = row;
			loc[1] = col;
			getWeaponLocations().put(weapon, loc);
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
			try
			{
				return cells[row][col].getWeapon();
			}
			catch (RException e)
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * return the Weapon 1 or 2 from a particular x,y location in 2D environment
	 * array
	 * 
	 * @param row
	 *            - row coordinate from 2D environment array
	 * 
	 * @param col
	 *            - column coordinate from 2D environment array
	 * 
	 * @param 1
	 *            or 2 gives the weapon in slot 1 or slot 2
	 * 
	 * @return requested LifeForm (null if empty)
	 */
	public Weapon getWeapon(int row, int col, int w)
	{

		if (cells[row][col] != null)
		{
			if (w == 1)
			{
				return cells[row][col].getWeapon1();
			}
			if (w == 2)
			{
				return cells[row][col].getWeapon2();
			}
		}

		return null;

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
			cells[row][col].removeWeapon(removeMe);
			getWeaponLocations().remove(removeMe);
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
		if ((getEntityLocations().get(entity1) == null) || (getEntityLocations().get(entity2) == null))
		{
			throw new EnvironmentException(
					"you need 2 (emphasis on the number 2) entitys to figure out the distance between 2 entities");
		}
		else
		{
			int[] l1 = getEntityLocations().get(entity1);
			int[] l2 = getEntityLocations().get(entity2);
			int rDelta = l2[0] - l1[0];
			int cDelta = l2[1] - l1[1];
			rDelta = rDelta * rDelta;
			cDelta = cDelta * cDelta;
			double distance = Math.sqrt(rDelta + cDelta);
			return distance; // each cell is 10 feet by 10 feet
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
		return getEntityLocations().get(lf);
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
		String direction = itsMyTurn.getDirection();
		int[] actualLocation = getLifeFormLocation(itsMyTurn);
		int[] proposedLocation = new int[] { actualLocation[0], actualLocation[1] };

		if (direction == "North")
		{
			proposedLocation[0] = actualLocation[0] - speed;
			proposedLocation = assessMovementBoundaries(proposedLocation);
			if (!Arrays.equals(proposedLocation, actualLocation)) // pass if i'm already in my proposed spot
			{
				while (someoneInMySpot(proposedLocation) == true)
				{
					proposedLocation[0]++;
				}
			}
		}
		else if (direction == "South")
		{
			proposedLocation[0] = actualLocation[0] + speed;
			proposedLocation = assessMovementBoundaries(proposedLocation);
			if (!Arrays.equals(proposedLocation, actualLocation)) // pass if i'm already in my proposed spot
			{
				while (someoneInMySpot(proposedLocation) == true)
				{
					proposedLocation[0]--;
				}
			}
		}
		else if (direction == "West")
		{
			proposedLocation[1] = actualLocation[1] - speed;
			proposedLocation = assessMovementBoundaries(proposedLocation);
			if (!Arrays.equals(proposedLocation, actualLocation)) // pass if i'm already in my proposed spot
			{
				while (someoneInMySpot(proposedLocation) == true)
				{
					proposedLocation[1]++;
				}
			}
		}
		else if (direction == "East")
		{
			proposedLocation[1] = actualLocation[1] + speed;
			proposedLocation = assessMovementBoundaries(proposedLocation);
			if (!Arrays.equals(proposedLocation, actualLocation)) // pass if i'm already in my proposed spot
			{
				while (someoneInMySpot(proposedLocation) == true)
				{
					proposedLocation[1]--;
				}
			}
		}

		proposedLocation = assessMovementBoundaries(proposedLocation);
		if (someoneInMySpot(proposedLocation) == false)
		{
			// TODO need to properly add or remove
			removeLifeForm(actualLocation[0], actualLocation[1]);
			addLifeForm(proposedLocation[0], proposedLocation[1], itsMyTurn);

			// getEntityLocations().put(itsMyTurn, intermediateLocation);
		}
		else
		{
			shift(direction, proposedLocation);

		}
	}

	/**
	 * this little guy will check if the location is open and shift in the
	 * appropriate direction
	 * 
	 * @param direction
	 * @return
	 */
	public int[] shift(String direction, int[] proposedLocation)
	{
		int[] outputLocation = proposedLocation;
		while (someoneInMySpot(proposedLocation) == true)
		{
			if (direction == "North")
			{
				outputLocation[0]++;
			}
			if (direction == "South")
			{
				outputLocation[0]--;
			}
			if (direction == "West")
			{
				outputLocation[1]++;
			}
			if (direction == "East")
			{
				outputLocation[1]--;
			}
		}
		return outputLocation;

	}

	/**
	 * Check to see whether or not your proposed location is within the boundaries
	 * of the game map Pass param propLoc as the suggested new location. Return an
	 * adjusted/corrected number
	 * 
	 * Note: the size of the world (let's say 10x10) needs to be adjusted because
	 * our cells array starts counting cells from 0 not 1 (so 9x9)
	 * 
	 * @param propLoc
	 * @return
	 */
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
		else if (propLoc[0] >= numrows)
		{
			newProposal[0] = numrows - 1;// adjust to array index
		}
		else if (propLoc[1] >= numcols)
		{
			newProposal[1] = numcols - 1;// adjust to array index
		}
		return newProposal;
	}

	private boolean someoneInMySpot(int[] interLoc)
	{
		int numConflicts = 0;
		for (int[] value : getEntityLocations().values())
		{
			if ((value[0] == interLoc[0]) && (value[1] == interLoc[1]))
			{
				numConflicts++;
			}

		}
		if (numConflicts > 0)
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

		int[] dim = { numrows, numcols };
		return dim;

	}

	/**
	 * allow access to the collection of LifeForms and their grid locations on the
	 * map
	 * 
	 * @return
	 */
	public HashMap<LifeForm, int[]> getEntityLocations()
	{
		return entityLocations;
	}

	/**
	 * all access to the collection of weapons and their grid locations
	 * 
	 * @return
	 */
	public HashMap<Weapon, int[]> getWeaponLocations()
	{
		return weaponLocations;
	}

}