package state;

import lifeform.LifeForm;

public class AI
{
	protected ActionState currentState;
	protected ActionState[] myStates;

	AI(ActionState changeStateTo, LifeForm myLF)
	{

		currentState = changeStateTo;
		myStates[0] = new HasWeaponState(myLF);
		myStates[1] = new DeadState(myLF);
		myStates[2] = new OutOfAmmoState(myLF);
		myStates[3] = new NoWeaponState(myLF);
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
	 * returns the state that is the current active state for a particular LifeForm
	 * 
	 * @param changeStateTo
	 */
	public void changeCurrentState(ActionState changeStateTo)
	{
		currentState = changeStateTo;
	}

}
