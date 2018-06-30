/**
 * AI is the "intelligence" manager for each of the LifeForms.
 * It keeps track of the current state that the lifeform is in as well as all of the states it could be in.  
 * it's up to the states to decide what state to be in next. 
 * 
 * Importantly, once evaluate() gets called, it calls the evaluate function on the substate.
 * 
 * @author Rob M, Chandana G
 */

package state;

import exceptions.RException;
import lifeform.LifeForm;

public class AI
{
	protected ActionState currentState;
	public final ActionState hasWeaponState;
	public final ActionState deadState;
	public final ActionState outOfAmmoState;
	public final ActionState noWeaponState;

	/**
	 * set up the 4 possible states for the life form in question AND set the
	 * default current state to noWeaponState; pass in the lifeForm that the states
	 * apply to.
	 * 
	 * @param myLF
	 * @throws RException
	 */
	public AI(LifeForm myLF) throws RException
	{
		hasWeaponState = new HasWeaponState(myLF, this);
		deadState = new DeadState(myLF, this);
		outOfAmmoState = new OutOfAmmoState(myLF, this);
		noWeaponState = new NoWeaponState(myLF, this);
		currentState = noWeaponState;
	}

	/**
	 * returns what the current state is for the particular LifeForm
	 * 
	 * @return
	 */
	public ActionState getState()
	{
		return currentState;
	}

	/**
	 * sets the current state for this LifeForm to noAmmoState
	 */
	public void changeToNoAmmoState()
	{
		currentState = outOfAmmoState;
	}

	/**
	 * sets the current state for this LifeForm to deadState
	 */
	public void changeToDeadState()
	{
		currentState = deadState;
	}

	/**
	 * sets the current state for this LifeForm to hasWeaponState
	 */
	public void changeToHasWeaponState()
	{
		currentState = hasWeaponState;
	}

	/**
	 * sets the current state for this LifeForm to noWeaponState
	 */
	public void changeToNoWeaponState()
	{
		currentState = noWeaponState;
	}

	/**
	 * will make a dispatch request to the current (active) state and it will do
	 * it's thing to determine what actions are needed by the lifeform as well as
	 * what state to be in next
	 * 
	 * @throws RException
	 */
	public void evaluate() throws RException
	{
		currentState.evaluate();
	}

}
