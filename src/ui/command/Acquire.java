/**
 * @author Chandana G
 * Checks to see whether the active life forms turns in the direction the player wants it to.
 */
package ui.command;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import weapon.Weapon;

public class Acquire implements Command{
	LifeForm lifeform;
	Environment theWorld;
	Weapon w;

	@Override
	public void execute() throws RException {
		theWorld = Environment.getWorld();
		lifeform = theWorld.itsMyTurn;
		int[] lifeformLoc = theWorld.getLifeFormLocation(lifeform);
		Weapon weapon = Environment.getWorld().getWeapon(lifeformLoc[0], lifeformLoc[1]);
		System.out.println(weapon); 
		lifeform.pickUpWeapon(weapon); //Should be pickUpWeapon()?
	}
}
