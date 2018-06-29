package state;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public abstract class ActionState
{

	public final LifeForm myLF;
	protected Environment theWorld;
	protected AI ai;

	ActionState(LifeForm lifeForm, AI myAI)
	{
		myLF = lifeForm;
		theWorld = Environment.getWorld();
		ai = myAI;
	}

	// only for AIState
	public void evaluate()
	{
		doExceptionPlease();
	}

	public void search()
	{
		doExceptionPlease();
	}

	public void acquire()
	{
		doExceptionPlease();
	}

	public void attack()
	{
		doExceptionPlease();
	}

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
	
	private void doExceptionPlease()
	{
		new RException("sorry there, that call isn't valid for this state");
		
	}

}
