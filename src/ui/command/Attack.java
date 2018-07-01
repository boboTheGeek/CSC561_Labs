/**
 * @Author Chandana G
 * Selected LifeForm attacks in the direction it is facing. To
 * keep things simple a LifeForm will only attack targets in a direct line in front of
 * the LifeForm. The LifeForm should only fire its weapon if there is a target.
 * The LifeForm will always attack the closest enemy target.
 */

package ui.command;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;

public class Attack implements Command{
	Environment theWorld;
	LifeForm  life2;  
	
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
		/**
		 * Checks the entire all the columns of the same row starting from the column next to the active lifeform's 
		 * position to see if there is any lifeform present in it's line of sight
		 */
		int i = activeLifeFormLocation[0];
			for(int j = activeLifeFormLocation[1]+1; j < col; j++)
			{
				if(theWorld.getLifeForm(i, j) != null) {
					life2 = theWorld.getLifeForm(i, j);
					break;
				}
			}
		
		System.out.println("life2" + life2);
		if(life2 != null) {
			theWorld.itsMyTurn.mountAttack(life2);
		}
			
	}
}
