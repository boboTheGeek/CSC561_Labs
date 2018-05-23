/*
 * Human class, subclass of Lifeform
 * Manges armor and does some handling of name along with lifepoints
 * Author: Rob Miles
 */

package lifeform;

public class Human extends LifeForm
{

	private int armorPoints;

	/*
	 * construct human, superclass Lifeform to set name and lifepoints set armor
	 * locally as instance variable
	 */
	public Human(int armor, String name, int lifepoints)
	{
		super(name, lifepoints);

		setArmorPoints(armor);
	}

	/*
	 * @return the Human's armor point value from instance variable
	 */
	public int getArmorPoints()
	{
		return armorPoints;
	}

	/*
	 * @return void
	 * 
	 * sets the instance variable for armor
	 * don't accept negative values
	 */
	public void setArmorPoints(int armor)
	{
		if (armor >= 0) {
			armorPoints = armor;
		} else {
			armorPoints = 0;
		}
		
	}

}
