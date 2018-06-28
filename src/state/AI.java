package state;

import exceptions.RException;
import lifeform.LifeForm;

public class AI
{
	protected ActionState currentState;
	protected ActionState hasWeaponState;
	protected ActionState deadState;
	protected ActionState noAmmoState;
	protected ActionState noWeaponState;

	AI(LifeForm myLF) throws RException
	{
		hasWeaponState = new HasWeaponState(myLF, this);
		deadState = new DeadState(myLF, this);
		noAmmoState = new OutOfAmmoState(myLF, this);
		noWeaponState = new NoWeaponState(myLF, this);
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
		currentState = noAmmoState;
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
	 * sets the current state for this LifeForm to noAmmoState
	 */
	public ActionState getOutOfAmmoState()
	{
		return noAmmoState;
	}
	/**
	 * sets the current state for this LifeForm to deadState
	 */
	public ActionState getDeadState()
	{
		return deadState;
	}
	/**
	 * sets the current state for this LifeForm to hasWeaponState
	 */
	public ActionState getHasWeaponState()
	{
		return hasWeaponState;
	}
	/**
	 * sets the current state for this LifeForm to noWeaponState
	 */
	public ActionState getNoWeaponState()
	{
		return noWeaponState;
	}
}
