/**
 * @Author Chandana G 
 * Attempts to move the selected LifeForm maxSpeed spaces in
 * the direction it is facing using the movement rules of the Environment.
 */

package ui.command;

import environment.Environment;

public class Move implements Command{

	Environment theWorld = Environment.getWorld();
	@Override
	public void execute() {
		theWorld.movePlayer(Environment.itsMyTurn);
	}

	
}
