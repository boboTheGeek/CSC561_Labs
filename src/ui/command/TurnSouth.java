/**
 * @Author Chandana G
 */

package ui.command;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public class TurnSouth implements Command{

	Environment theWorld;
	LifeForm lifeform;
	@Override
	public void execute() throws RException {
		System.out.println("direction:" + "" + "South");
		theWorld.itsMyTurn.rotate("South");			
	}

	
}
