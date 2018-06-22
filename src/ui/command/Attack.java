package ui.command;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;

public class Attack implements Command{
	Environment theWorld;
	LifeForm life, life2;
	@Override
	public void execute() throws RException, EnvironmentException { 
		theWorld.addLifeForm(4, 6, life2);
		theWorld.itsMyTurn.mountAttack(life2);
	}
	

}
