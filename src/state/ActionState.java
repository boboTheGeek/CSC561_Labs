/**
 * Sets the basic template up for generic states.
 * 
 * different emplementations of algorithms will be decided within the states themselves
 * 
 * @author Rob Miles, Chandana G
 * 
 */
package state;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public abstract class ActionState
{

	public final LifeForm myLF;
	protected Environment theWorld;
	protected AI ai;

	/**
	 * generic constructor accepts the lifeform that the state will be attached to
	 * as well as the AI that will keep track of that LifeForm's active state. F
	 * 
	 * @param lifeForm
	 * @param myAI
	 */
	ActionState(LifeForm lifeForm, AI myAI)
	{
		myLF = lifeForm;
		theWorld = Environment.getWorld();
		ai = myAI;
	}

	/*
	 * Abstract definition without any fun guts, only for AIState
	 */
	public void evaluate() throws RException // throws RException
	{
		doExceptionPlease();
	}

	/**
	 * abstract class declaration of the function implemented in the subclass/state
	 * 
	 * @throws RException
	 */
	public void search() throws RException
	{
		doExceptionPlease();
	}

	/**
	 * abstract class declaration of the function implemented in the subclass/state
	 */
	public void acquire()
	{
		doExceptionPlease();
	}

	/**
	 * abstract class declaration of the function implemented in the subclass/state
	 */
	public void attack()
	{
		doExceptionPlease();
	}

	/**
	 * abstract class declaration of the function implemented in the subclass/state
	 */
	public void reload()
	{
		doExceptionPlease();
	}

	/**
	 * evaluates whether or not the subject LifeForm in question is dead. They will
	 * be considered dead if
	 */
	public void dead()
	{
		doExceptionPlease();
	}

	/**
	 * regenerates a dead Lifeform. Overridden in the DeadState extension of
	 * AtionState and not used in the other substates.
	 */
	public void respawn()
	{
		doExceptionPlease();
	}

	/**
	 * helps to call exceptions so they dont propogate out of control
	 */
	private void doExceptionPlease()
	{
		new RException("sorry there, that call isn't valid for this state");

	}

	/**
	 * sets a randomly selected direction
	 * 
	 * @return
	 */
	public String getRandomDirectionToSearch()
	{
		return ai.noWeaponState.getRandomDirectionToSearch();

	}

}
