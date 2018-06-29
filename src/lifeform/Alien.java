/**
 * Alien lifefor class that extends LifeForm class
 * handles alien behavior including recovery type as well as name and lifepoints
 * 
 * @Author: Rob Miles
 */

package lifeform;

import exceptions.RException;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

public class Alien extends LifeForm
{
	protected RecoveryBehavior recoveryBehavior;
	protected int recoveryRate;

	/**
	 * Initialize Alien, calling superclass LifeForm passing name and points to
	 * populate instance variables of LifeForm
	 * 
	 * @param name
	 *            - the name of your alien
	 * @param points
	 *            - the number of alien lifepoints left
	 * @throws RException 
	 * 
	 */
	public Alien(String name, int points) throws RException
	{

		this(name, points, new RecoveryNone(), 0);

	}

	/**
	 * create an Alien that will accept a name, lifePoints and set a recovery
	 * behavior type from interface implementation
	 * 
	 * @param name
	 *            - the name of your alien
	 * @param points
	 *            - the number of alien lifepoints left
	 * @param rb
	 *            - recovery behavior object to set
	 * @param recov
	 * 
	 * @throws RException 
	 * 
	 */
	public Alien(String name, int points, RecoveryBehavior rb, int recov) throws RException
	{
		super(name, points, 10); // default attack points for alien = 10
		recoveryBehavior = rb;
		maxSpeed = 2;
		if (recov < 0)
		{
			throw new RException("input can't be negative dude");
		}
		else
		{
			recoveryRate = recov;
		}
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
		if ((recoveryRate > 0) && (myTime != 0)) // only recover if recovery rate is greater than 0
		{
			//System.out.println(myTime + "=time ," + recoveryRate + "=rate ," + "modulus "
			//+ myTime%recoveryRate);
			if (myTime % recoveryRate == 0)
				currentLifePoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
		}
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
	 * setter for recovery rate to adjust what was set by constructor
	 * 
	 * @param rate
	 *            - the rate that you want the instance variable for recoveryRate to
	 *            be set to
	 */
	public void setRecovery(int rate)
	{
		recoveryRate = rate;

	}
	
	@Override
	public void update(int time)
	{
		myTime = time;
		recover();
	}
}
