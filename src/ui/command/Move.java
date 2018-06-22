package ui.command;

import environment.Environment;

public class Move implements Command{

	Environment theWorld;
	@Override
	public void execute() {
		theWorld.movePlayer();
	}

	
}
