/**
 * Human class, subclass of Lifeform
 * Manges armor and does some handling of name along with lifepoints
 * 
 * @Author: Rob Miles
 */

package lifeform;

public class Human extends LifeForm
{

	private int armorPoints;

	/**
	 * construct human, superclass Lifeform to set name and lifepoints set armor
	 * locally as instance variable
	 * 
	 * also sets default
	 * 
	 * @param armor
	 *            - amount of armor protection
	 * @param name
	 *            - the name of the being
	 * @param lifepoints
	 *            - basically the health of the being
	 */
	public Human(int armor, String name, int lifepoints)
	{
		super(name, lifepoints, 5); // last param is default attack points

		setArmorPoints(armor);
	}

	/**
	 * just gets the armor point value for the being's intance
	 * 
	 * @return the Human's armor point value from instance variable
	 */
	public int getArmorPoints()
	{
		return armorPoints;
	}

	/**
	 * @param armor
	 *            - the value that armor should be set to for this being
	 * 
	 *            sets the instance variable for armor don't accept negative values
	 */
	public void setArmorPoints(int armor)
	{
		if (armor >= 0)
		{
			armorPoints = armor;
		}
		else
		{
			armorPoints = 0;
		}
	}
}
