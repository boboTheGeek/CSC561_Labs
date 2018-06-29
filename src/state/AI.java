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

	public AI(LifeForm myLF)
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

	public void evaluate()
	{
		currentState.evaluate();
	}

}
