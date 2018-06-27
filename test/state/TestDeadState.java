package state;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestDeadState
{

	@Test
	public void testinitialize()
	{
		LifeForm bill = new Human(22, "bill", 22);
		ActionState as = new DeadState(bill);
		assertEquals(as.myLF, bill);
	}

	@Test
	public void testEvaluate()
	{
		
		LifeForm bill = new Human(22, "bill", 22);
		ActionState as = new DeadState(bill);
		//call respawn
		as.evaluate();
		//check you respawned
		
		//check you're put to the no weapon state
		AI ai = new AI(as);
		assertEquals(NoWeaponState(), ai.getState());
		
	}

	@Test
	public void testRespawn() throws EnvironmentException, RException
	{
		Environment.resetWorld();
		Environment.createWorld(5, 5);
		Environment theWorld = Environment.getWorld();
		Weapon w = new Pistol();
		LifeForm bill = new Human(0, "bill", 22);
		LifeForm sandra = new Human(0, "sandra", 22);
		theWorld.addLifeForm(2, 2, bill);
		theWorld.addLifeForm(3, 3, sandra);
		theWorld.addWeapon(2, 2, w);
		bill.getWeapon();
		
		ActionState as = new DeadState(bill);

		sandra.mountAttack(bill);
		//assertTrue(as.myLF.getLifePoints() != 22);

		//System.out.println(as.myLF.getLifePoints());

		as.respawn();

		// test that the life is regenerated

		assertEquals(22, as.myLF.getLifePoints());
		// test that LF shows up in a new location

		// test that weapon is dropped
		int[] i = {2,2};
		assertEquals(i, theWorld.getWeapon(2, 2));
	}

}
