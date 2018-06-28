package state;

import java.util.ArrayList;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;

public abstract class ActionState
{

	protected LifeForm myLF;
	protected Environment theWorld;
	protected AI ai;


	ActionState(LifeForm lifeForm, AI myAI)
	{
		myLF = lifeForm;
		theWorld = Environment.getWorld();
		ai = myAI;
	}

	// only for AIState
	public void evaluate() throws RException //throws RException
	{
	}

	public void search() throws RException
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

	public String getRandomDirectionToSearch() {
		return ai.noWeaponState.getRandomDirectionToSearch();
		// TODO Auto-generated method stub
		
	}

}
