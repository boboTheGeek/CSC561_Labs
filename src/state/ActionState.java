package state;

import environment.Environment;
import lifeform.LifeForm;

public abstract class ActionState
{
	
	protected LifeForm myLF;
	protected Environment theWorld;

	ActionState(LifeForm lifeForm){
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
	 * evaluates wheter or not the subject LifeForm in question is dead. They will
	 * be considered dead if
	 */
	public void dead()
	{
	}

	public void respawn()
	{
	}

}
