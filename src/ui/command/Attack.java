package ui.command;

import environment.Environment;
import exceptions.RException;

public class Attack implements Command{
	Environment theWorld;
	LifeForm life;
	@Override
	public void execute() throws RException {
		theWorld.itsMyTurn.mountAttack(victim);
	}
	

}
