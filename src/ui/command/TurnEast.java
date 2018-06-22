package ui.command;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public class TurnEast implements Command{

	Environment theWorld;
	LifeForm lifeform;
	@Override
	public void execute() throws RException {
		theWorld.itsMyTurn.rotate("East");			
	}

	
}
