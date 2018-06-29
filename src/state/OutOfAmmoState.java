/**
 * This class is a state that you can be in when you have no ammunition left in your gun/weapon.   
 * In this eventuality, the AI can call an evaluate method which determines if you've been killed
 *  since you're last turn and otherwise allows you to reload. 
 * 
 * @author Rob Miles
 * 
 */
package state;

import lifeform.LifeForm;

public class OutOfAmmoState extends ActionState
{
	/**
	 * Constructor -- this class will keep track of the lifeForm which it applies to
	 * and the AI for that lifeform (which holds all of the 4 possible states so it
	 * can decide which is the active state)
	 * 
	 * @param lifeForm
	 * @param ai
	 */
	OutOfAmmoState(LifeForm lifeForm, AI ai)
	{
		super(lifeForm, ai);

	}

	/**
	 * evaluate the conditions of this lifeform and determine actions if out of
	 * lifePoints, go to dead state otherwise, if out of ammo, then reload you
	 */
	public void evaluate()
	{

		if (myLF.getLifePoints() == 0)
		{
			dead();

		}
		else if (myLF.getWeapon().getCurrentAmmo() == 0)
		{
			reload();
		}
	}

	/**
	 * IN the event that you're dead, then go to the dead state please
	 */
	public void dead()
	{
		ai.changeToDeadState();
	}

	/**
	 * provided that you aren't already dead, then do something useful... say..
	 * reload your gun (since it was already decided by someone or something that
	 * you're out of ammo
	 */
	public void reload()
	{
		myLF.reloadWeapon();
		ai.changeToHasWeaponState();
	}

}
