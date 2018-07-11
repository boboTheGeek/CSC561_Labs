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
	 * The evaluation method is the one that all states get called in a generic
	 * fashion. In this state, we simply trigger a respawn action
	 */
	@Override
	public void evaluate()
	{
		respawn();
	}

	/**
	 * Once the lifeForm has been killed till it is dead, it will then have the
	 * opportunity to re-spawn. over and over.. so, this method resets the
	 * lifeform's lifepoints, drops it's weapon and picks a new random spot to
	 * pop-up in.
	 */
	public void respawn()
	{

		// reset lifepoints
		myLF.resetLifePointsToMax();

		// drop your weapon
		int[] myLFLoc = theWorld.getLifeFormLocation(myLF);

		// see if you can drop the weapon on the spot
		// or drop it in a random location
		int[] rLoc = theWorld.getRandomLocation4Weapon(myLFLoc);

		try
		{
			theWorld.addWeapon(rLoc[0], rLoc[1], myLF.getWeapon());
		} catch (RException e)
		{
			e.printStackTrace();
		}
		myLF.dropWeapon();

		theWorld.removeLifeForm(myLFLoc[0], myLFLoc[1]);

		int[] randLoc = theWorld.getRandomLocation4LifeForm();
		theWorld.addLifeForm(randLoc[0], randLoc[1], myLF);
		// change the active state that the AI has to no weapon state
		ai.changeToNoWeaponState();
	}

}
