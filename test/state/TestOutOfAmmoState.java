package state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

public class TestOutOfAmmoState
{

	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(5, 5);
	}
	
	@Test
	public void testInitialization() throws RException
	{

		Environment theWorld = Environment.getWorld();

		LifeForm bill = new Human(0, "bill", 22);
		theWorld.addLifeForm(2, 2, bill);
		AI myAi = new AI(bill);
		ActionState oos = myAi.getOutOfAmmoState();

		assertEquals(bill, oos.myLF);
		assertEquals(myAi, oos.ai);

	}

	@Test
	public void testWeaponReload() throws RException
	{
		Environment theWorld = Environment.getWorld();

		LifeForm bill = new Human(0, "bill", 22);
		theWorld.addLifeForm(2, 2, bill);
		AI myAi = new AI(bill);
		ActionState oos = myAi.getOutOfAmmoState();
	}

	@Test
	public void testMovesToCorrectState()
	{
		Environment theWorld = Environment.getWorld();

		LifeForm bill = new Human(0, "bill", 22);
		theWorld.addLifeForm(2, 2, bill);
		AI myAi = new AI(bill);
		ActionState oos = myAi.getOutOfAmmoState();
	}

	@Test
	public void testTestIfDead() throws RException, EnvironmentException
	{
		Environment theWorld = Environment.getWorld();
	
		LifeForm bill = new Human(0, "bill", 10);
		LifeForm sandra = new Alien("rasputin", 40);
		AI myAi = new AI(bill);
		ActionState oos = myAi.getOutOfAmmoState();
		theWorld.addLifeForm(3, 3, bill);
		theWorld.addLifeForm(3, 4, sandra);
		sandra.mountAttack(bill);
		sandra.mountAttack(bill);
		sandra.mountAttack(bill);
		sandra.mountAttack(bill);
		sandra.mountAttack(bill);
		sandra.mountAttack(bill);
		assertEquals(0, bill.getLifePoints());
		oos.evaluate();
		assertTrue(oos.ai.getState() instanceof DeadState);
		
		
	}
}
