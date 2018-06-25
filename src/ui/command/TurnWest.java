package ui.command;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public class TurnWest implements Command{

	Environment theWorld;
	LifeForm lifeform;
	@Override
	public void execute() throws RException {
		System.out.println("direction:" + "" + "West");
		theWorld.itsMyTurn.rotate("West");			
	}

	
}
