package state;

import java.util.ArrayList;

import environment.Environment;
import lifeform.LifeForm;

public abstract class ActionState
{

	protected LifeForm myLF;
	protected Environment theWorld;
	protected AI ai;


	ActionState(LifeForm lifeForm)
	{
		myLF = lifeForm;
		theWorld = Environment.getWorld();

	}

	// only for AIState
	public void evaluate()
	{
	}

	public void search()
	{
	}

	public void acquire()
	{
	}

	public void attack()
	{
	}

	public void reload()
	{
	}

	/**
	 * evaluates whether or not the subject LifeForm in question is dead. They will
	 * be considered dead if
	 */
	public void dead()
	{
	}

	/**
	 * regenerates a dead Lifeform.  Overridden in the DeadState extension of AtionState and not used in the other substates.
	 */
	public void respawn()
	{
		//nothing
	}

}
