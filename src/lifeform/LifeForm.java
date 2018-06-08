/**
 * Keeps track of the information associated with a simple life form. Also
 * provides the functionality related to the life form. 
 * 
 * @Author: Rob Miles
 */

package lifeform;

import gameplay.TimeObserver;

public class LifeForm implements TimeObserver
{

	protected String myName;
	protected int currentLifePoints;
	protected int attackStrength;
	protected int myTime = 0;

	/**
	 * Create an instance
	 *
	 * @param name
	 *            the name of the life form
	 * @param points
	 *            the current starting life points of the life form
	 * 
	 * @param atStr
	 *            sets the attack strength of the lifeform
	 */
	public LifeForm(String name, int points, int atStr)
	{
		myName = name;
		currentLifePoints = points;
		attackStrength = atStr;
	}

	public LifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = points;
		attackStrength = 0;
	}

	/**
	 * gets and returns number of current life points (health)
	 * 
	 * @return the amount of current life points the life form has.
	 */
	public int getLifePoints()
	{
		return currentLifePoints;
	}

	/**
	 * gets and returns the name of the lifeform in question
	 * 
	 * @return the name of the life form.
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * removes damage from life points and won't set life points below 0
	 * 
	 * @param damage
	 *            - the amount to reduce life points by
	 */
	public void takeHit(int damage)
	{
		int proposedLifePoints = currentLifePoints - (damage);

		if (proposedLifePoints <= 0)
		{
			currentLifePoints = 0;
		}
		else
		{
			currentLifePoints = proposedLifePoints;
		}
	}

	public int getAttackStrength()
	{
		return attackStrength;
	}

	public void mountAttack(LifeForm victim)
	{
		if (currentLifePoints != 0)
		{
			if (victim instanceof Human) // victim is human
			{
				// TODO is refactoring to be in Human subclass, override takeHit?
				int hitVal = attackStrength - ((Human) victim).getArmorPoints();
				if (hitVal > 0)
				{
					victim.takeHit(hitVal);
				}
			}
			else // victim is an alien
			{
				victim.takeHit(attackStrength);
			}
		}
	}

	@Override
	public void updateTime(int time)
	{
		myTime = time;
	}
}