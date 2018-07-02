/**
 * @author Chandana G
 * 
 * When a player has no weapon he transitions into no weapon state
 */
package state;

import exceptions.RException;
import lifeform.LifeForm;
import weapon.Weapon;

public class NoWeaponState extends ActionState
{

	// DeadState dead;
	String randomDirectionPicked;
	int i, j;
	String[] directions =
	{ "North", "South", "East", "West" };
	int index;
	String currentDirection;
	int[] loc;
	int[] theWorldLoc;
	int x, y;

	public NoWeaponState(LifeForm lifeForm, AI ai) throws RException
	{
		super(lifeForm, ai);

		currentDirection = myLF.getDirection();
		loc = theWorld.getLifeFormLocation(myLF);
		theWorldLoc = theWorld.getEnvironmentDimensions();
		x = theWorldLoc[0];
		y = theWorldLoc[1];
	}

	/**
	 * Evaluates whether the current active is dead
	 * 
	 * @throws RException
	 */
	@Override 
	public void evaluate() throws RException
	{
		int points = myLF.getLifePoints();
		if (myLF.getLifePoints() != 0)
		{
			search();
			
		}
		else
		{

			dead();

		}

	}

	/**
	 * Changes to dead state when a player's life points are zero
	 */
	public void dead()
	{
		ai.changeToDeadState();
	}

	/**
	 * Lifeform tries to pickup a weapon if one exists in the cell it's currently in
	 * otherwise it finds a new cell to move into and changes the direction it's facing goes on to search in that
	 * direction until end of the grid in its next turn
	 */
	public void search() throws RException
	{
		loc = theWorld.getLifeFormLocation(myLF);
		Weapon w = theWorld.getWeapon(loc[0], loc[1]);
		if (w != null)
		{
			myLF.pickUpWeapon(w);

		}
		else
		{

			randomDirectionPicked = getRandomDirectionToSearch();
			if (currentDirection != randomDirectionPicked)
			{
				if (randomDirectionPicked == "North")
				{
					/**
					 * When direction is North and currentLocation = (5, 6), it goes to search down
					 * the grid at locations (4, 6), (3, 6)...until it reaches the end cell in that
					 * direction
					 */
					j = loc[1];
					{
						for (i = loc[0] - 1; i > 0;) // moving down the grid
						{
							if (theWorld.getWeapon(i, j) != null)
							{
								Weapon weapon = theWorld.getWeapon(i, j);
								myLF.pickUpWeapon(weapon);
								theWorld.removeWeaponByCell(i, j);
								ai.changeToHasWeaponState();
								break;
							}
							if (i == x - 1)
							{
								if (theWorld.getWeapon(i, j) == null)
								{
									ai.changeToNoWeaponState();
								}
							}
							i--;

						}
					}
				}
				if (randomDirectionPicked == "South")
				{
					/**
					 * When direction is South and currentLocation = (5, 6), it goes to search down
					 * the grid at locations (6, 6), (7, 6)...until it reaches the end cell in that
					 * direction
					 */

					j = loc[1]; // 7
					{
						// i = 6, x = 20
						for (i = loc[0] + 1; i < x;) // moving down the grid
						{
							if (theWorld.getWeapon(i, j) != null)
							{
								Weapon weapon = theWorld.getWeapon(i, j);
								myLF.pickUpWeapon(weapon);
								theWorld.removeWeaponByCell(i, j);
								ai.changeToHasWeaponState();
								break;
							}
							if (i == x - 1)
							{
								if (theWorld.getWeapon(i, j) == null)
								{
									ai.changeToNoWeaponState();

								}
							}
							i++;

						}
					}

				}
				if (randomDirectionPicked == "East")
				{
					/**
					 * When direction is East and currentLocation = (5, 6), it goes to search down
					 * the grid at locations (5, 7), (5, 8)...until it reaches the end cell in that
					 * direction
					 */
					i = loc[0];
					{
						for (j = loc[1] + 1; j < x;) // moving down the grid
						{
							if (theWorld.getWeapon(i, j) != null)
							{
								Weapon weapon = theWorld.getWeapon(i, j);
								myLF.pickUpWeapon(weapon);
								theWorld.removeWeaponByCell(i, j);
								ai.changeToHasWeaponState();
								break;
							}
							if (j == x - 1)
							{
								if (theWorld.getWeapon(i, j) == null)
								{
									ai.changeToNoWeaponState();

								}
							}
							j++;

						}
					}

				}
				if (randomDirectionPicked == "West")
				{
					/**
					 * When direction is West and currentLocation = (5, 6), it goes to search down
					 * the grid at locations (5, 5), (5, 4)...until it reaches the end cell in that
					 * direction
					 */
					i = loc[0];
					{
						for (j = loc[1] - 1; j > 0;) // moving down the grid
						{
							if (theWorld.getWeapon(i, j) != null)
							{
								Weapon weapon = theWorld.getWeapon(i, j);
								myLF.pickUpWeapon(weapon);
								theWorld.removeWeaponByCell(i, j);
								ai.changeToHasWeaponState();
								break;
							}
							if (j == x - 1)
							{
								if (theWorld.getWeapon(i, j) == null)
								{
									ai.changeToNoWeaponState();
								}
							}
							j--;

						}
					}
				}
			}
		}
	}

	/**
	 * Picks a random direction for the lifeform to turn and go ahead with search for
	 * weapon
	 * 
	 * @return
	 */
	public String getRandomDirectionToSearch()
	{
		index = (int) (Math.random() * 3);
		if (directions[index] == currentDirection && index != 3)
		{
			return directions[index + 1];
		}
		if (directions[index] == currentDirection && index == 3)
		{
			return directions[index - 1];
		}
		return directions[index];
	}

}
