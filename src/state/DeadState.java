/**
 * the implementation of the state that the Lifeform goes into when it's dead.  
 * This happens when the lifepoints have reached 0 after the guy/girl has been shot at a bunch of times.
 * 
 * @author Rob Miles
 */

package state;

import exceptions.RException;
import lifeform.LifeForm;

public class DeadState extends ActionState
{
	/**
	 * Constructor -- this class will keep track of the lifeForm which it applies to
	 * and the AI for that lifeform (which holds all of the 4 possible states so it
	 * can decide which is the active state)
	 * 
	 * @param lifeForm
	 * @param ai
	 */
	DeadState(LifeForm lifeForm, AI ai)
	{
		super(lifeForm, ai);
	}

	/**
	 * The evaluation method is the one that all states get called in a generic fashion.  
	 * In this state, we simply trigger a respawn action
	 */
	public void evaluate()
	{
		respawn();
	}

	/**
	 * Once the lifeForm has been killed till it is dead, it will then have the opportunity to respawn.   over and over..
	 * so, this method resets the lifeform's lifepoints, drops it's weapon and picks a new random spot to pop-up in.
	 */
	public void respawn()
	{

		// reset lifepoints
		myLF.resetLifePointsToMax();

		// drop your weapon
		int[] myLFLoc = theWorld.getLifeFormLocation(myLF);

		try
		{
			theWorld.addWeapon(myLFLoc[0], myLFLoc[1], myLF.getWeapon());
		}
		catch (RException e)
		{
			//TODO try a new location
			e.printStackTrace();
		}
		myLF.dropWeapon();
		
		
		// pick a random spot, and keep checking to see if it's open or not
		int row = (int) (Math.random() * theWorld.getEnvironmentDimensions()[0]);
		int col = (int) (Math.random() * theWorld.getEnvironmentDimensions()[1]);
		
		while (theWorld.someoneInMySpot(new int[]{row, col}) == true)
		{
			row = (int) (Math.random() * theWorld.getEnvironmentDimensions()[0]);
			col = (int) (Math.random() * theWorld.getEnvironmentDimensions()[1]);
		}

		theWorld.removeLifeForm(myLFLoc[0], myLFLoc[1]);
		theWorld.addLifeForm(row, col, myLF);
		// change the active state that the AI has to no weapon state
		ai.changeToNoWeaponState();
	}

}
