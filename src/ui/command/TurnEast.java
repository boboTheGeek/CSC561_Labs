/**
 * @Author Chandana G
 */

package ui.command;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public class TurnEast implements Command{

	Environment theWorld;
	LifeForm lifeform;  // don't think we need this since we don't call lifeForm
	@Override
	public void execute() throws RException {
		System.out.println("direction:" + "" + "East");
		theWorld.itsMyTurn.rotate("East");			
	}

	
}
