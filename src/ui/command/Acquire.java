package ui.command;

import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

public class Acquire implements Command{
	LifeForm lifeform;
	Environment theWorld;
	Weapon w;

	@Override
	public void execute() {
		//theWorld.getWorld();
		
		lifeform = theWorld.itsMyTurn;
		lifeform.getWeapon();
	}
}
