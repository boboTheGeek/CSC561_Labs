/**
 * Alien lifefor class that extends LifeForm class
 * handles alien behavior including recovery type as well as name and lifepoints
 * 
 * @Author: Rob Miles
 */

package lifeform;

import recovery.RecoveryBehavior;

public class Alien extends LifeForm
{
	RecoveryBehavior recoveryBehavior;
	int maxLifePoints;

	/**
	 * Initialize Alien, calling superclass LifeForm passing name and points to
	 * populate instance variables of LifeForm
	 * 
	 * @param name
	 *            - the name of your alien
	 * @param points
	 *            - the number of alien lifepoints left
	 */
	public Alien(String name, int points)
	{
		super(name, points);
		// TODO fix two constructors
	}

	/**
	 * create an Alien that will accept a name, lifePoints and set a recovery
	 * behavior type from interface implentations
	 * 
	 * @param name
	 *            - the name of your alien
	 * @param points
	 *            - the number of alien lifepoints left
	 * @param rb
	 *            - recovery behavior object to set
	 */
	public Alien(String name, int points, RecoveryBehavior rb)
	{
		super(name, points);
		recoveryBehavior = rb;
	}

	/**
	 * Call calculateRecovery interface method, grab and pass appropriate values as
	 * params sets the currentLifePoints instance variable to the new value returned
	 * from calculateRecovery interface method
	 * 
	 * @param currentLife
	 *            - the current life points will be incremented via selected
	 *            recovery implementation
	 * @param maxLife
	 *            - the maximum level that life points can recover to
	 */
	public void recover(int currentLife, int maxLife)
	{
		currentLifePoints = calculateRecovery(currentLife, maxLife);
	}

	/**
	 * set or update the number of lifepoints remainig for the Alien
	 * 
	 * @param lp
	 *            - number of current life points to change to
	 */
	public void setCurrentLifePoints(int lp)
	{
		currentLifePoints = lp;
	}

	/**
	 * Calls the calculateRecovery interface method passing appropriate parameters
	 * to recieve an updated life point value
	 * 
	 * @param currentLife
	 *            - the number of life points remainig
	 * 
	 * @param maxLife
	 *            - the maximum number that can be recovered up-to (of life points)
	 * 
	 * @return what the current life points should be set to as a result of this
	 *         recovery
	 * 
	 *         public int calculateRecovery(int currentLife, int maxLife) { return
	 *         999; }
	 */

}
