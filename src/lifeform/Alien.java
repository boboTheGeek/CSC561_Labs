/**
 * Alien lifefor class that extends LifeForm class
 * handles alien behavior including recovery type as well as name and lifepoints
 * 
 * @Author: Rob Miles
 */

package lifeform;

import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

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

		this(name, points, new RecoveryNone());

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
		super(name, points, 10);  //  default attack points for alien = 10
		recoveryBehavior = rb;
		maxLifePoints = points;
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
	public void recover()
	{

		currentLifePoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
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
}
