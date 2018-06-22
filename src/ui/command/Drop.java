package ui.command;

import static org.junit.Assert.assertEquals;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Weapon;

public class Drop implements Command{

	Environment theWorld;
	@Override
	public void execute() throws RException {
		LifeForm life = theWorld.itsMyTurn;
		System.out.println(life);
		System.out.println(life.getWeapon());
		life.dropWeapon();
	}
}
