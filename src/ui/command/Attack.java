package ui.command;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;

public class Attack implements Command{
	Environment theWorld;
	LifeForm  life2;   //  interesting problem about how we are supposed to get life2 (aka victim)
					   //  I say that for now we just leave it hard coded as you have in line 17.  then just have to make it dynamically generated later
	@Override
	public void execute() throws RException, EnvironmentException { 
		
		//theWorld.itsMyTurn.mountAttack(life2);
		theWorld = Environment.getWorld();
		LifeForm activeLifeForm = theWorld.itsMyTurn;
		int[] dimensions = theWorld.getEnvironmentDimensions();
		int[] activeLifeFormLocation = theWorld.getLifeFormLocation(activeLifeForm);
		int row = dimensions[0];
		int col = dimensions[1];
		System.out.println(row);
		System.out.println(col);
		System.out.println(activeLifeFormLocation[0]);
		System.out.println(activeLifeFormLocation[1]);
		int i = activeLifeFormLocation[0];
			for(int j = activeLifeFormLocation[1]+1; j < col; j++)
			{
				if(theWorld.getLifeForm(i, j) != null) {
					life2 = theWorld.getLifeForm(i, j);
					break;
				}
			}
		
		System.out.println(life2);
		if(life2 != null) {
			theWorld.itsMyTurn.mountAttack(life2);
		}
			
	}
}
