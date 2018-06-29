/**
 * the implementation of the state that the Lifeform goes into when it's dead.  This happens when the lifepoints have reached 0.
 * 
 * @author Rob Miles
 */

package state;

import exceptions.RException;
import lifeform.LifeForm;

public class DeadState extends ActionState
{

	DeadState(LifeForm lifeForm, AI ai)
	{
		super(lifeForm, ai);

	}

	public void evaluate()
	{
		respawn();
	}

	public void respawn()
	{

		// reset lifepoints
		myLF.resetLifePointsToMax();

		// drop your weapon
		// TODO need to handle if it's not free space for a weapon
		int[] myLFLoc = theWorld.getLifeFormLocation(myLF);

		try
		{
			theWorld.addWeapon(myLFLoc[0], myLFLoc[1], myLF.getWeapon());
		}
		catch (RException e)
		{

			e.printStackTrace();
		}
		myLF.dropWeapon();
		// TODO - move this to environment... need to check that your location is free for a human
		int row = (int) (Math.random() * theWorld.getEnvironmentDimensions()[0]);
		int col = (int) (Math.random() * theWorld.getEnvironmentDimensions()[1]);

		theWorld.removeLifeForm(myLFLoc[0], myLFLoc[1]);
		theWorld.addLifeForm(row, col, myLF);
		// change the active state that the AI has to no weapon state
		ai.changeToNoWeaponState();
	}

}
