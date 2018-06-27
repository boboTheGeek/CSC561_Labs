package state;

import exceptions.RException;
import lifeform.LifeForm;
import weapon.Weapon;

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
		Weapon w = myLF.getWeapon();
		int[] myLFLoc = theWorld.getLifeFormLocation(myLF);
		myLF.dropWeapon();
		
		try
		{
			theWorld.addWeapon(myLFLoc[0], myLFLoc[1], w);
		}
		catch (RException e)
		{
			e.printStackTrace();
		}
		
		
		
		//move to no weapon state
		//change the active state that the AI has
	}

}
