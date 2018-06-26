package state;

import lifeform.LifeForm;

public class DeadState extends ActionState
{

	DeadState(LifeForm lifeForm)
	{
		super(lifeForm);

	}

	public void evalutat()
	{
	}

	public void respawn()
	{
		myLF.resetLifePointsToMax();
		
		
	}

}
