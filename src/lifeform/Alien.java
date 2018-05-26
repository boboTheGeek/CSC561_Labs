/**
 * Alien lifefor class that extends LifeForm class
 * handles alien behavior including recovery type as well as name and lifepoints
 * 
 * Author: Rob Miles
 */

package lifeform;

import recovery.RecoveryBehavior;

public class Alien extends LifeForm
{
	RecoveryBehavior recoveryBehavior;

	/**
	 * Initialize Alien, calling superclass LifeForm passing name and points to
	 * populate instance variables of LifeForm
	 * 
	 * @param name
	 * @param points
	 */
	public Alien(String name, int points)
	{

		super(name, points);

	}

	/**
	 * create an Alien that will accept a name, lifePoints and set a recovery
	 * behavior type from interface implentations
	 * 
	 * @param name
	 *            the name of your alien
	 * @param points
	 *            the nmber of
	 * @param rb
	 * 			recovery behavior object to set
	 */
	public Alien(String name, int points, RecoveryBehavior rb)
	{

		super(name, points);
		recoveryBehavior = rb;

	}

	public void recover(int currentLife, int maxLife)
	{
		calculateRecovery(currentLife, maxLife);

	}

	public int calculateRecovery(int currentLife, int maxLife)
	{
		return 999;
		
	}

	/**
	 * set or update the number of lifepoints remainig for the Alien
	 * 
	 * @param lp
	 *            number of current life points to change to
	 */
	public void setCurrentLifePoints(int lp)
	{
		currentLifePoints = lp;
	}

}
