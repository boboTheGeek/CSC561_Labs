/**
 * Keeps track of the information associated with a simple life form. Also
 * provides the functionality related to the life form. 
 * 
 * @Author: Rob Miles
 */

package lifeform;

public class LifeForm
{

	protected String myName;
	protected int currentLifePoints;

	/**
	 * Create an instance
	 *
	 * @param name
	 *            the name of the life form
	 * @param points
	 *            the current starting life points of the life form
	 */
	public LifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = points;
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
	 * @param damage - the amount to reduce life points by
	 */
	public void takeHit(int damage)
	{
		int proposedLifePoints = currentLifePoints - damage;

		if (proposedLifePoints <= 0) {
			currentLifePoints = 0;
		} else {
			currentLifePoints = proposedLifePoints;
		}
	}
}