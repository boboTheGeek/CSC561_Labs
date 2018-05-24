/*
 * Alien lifefor class that extends LifeForm class
 * handles alien behavior including recovery type as well as name and lifepoints
 * Author: Rob Miles
 */

package lifeform;

public class Alien extends LifeForm
{

	/*
	 * Initialize Alien, calling superclass LifeForm
	 * passing name and points to populate instance variables of LifeForm
	 */
	public Alien(String name, int points)
	{

		super(name, points);

	}

}
