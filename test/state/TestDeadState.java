package state;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.EnvironmentException;
import lifeform.Human;
import lifeform.LifeForm;

public class TestDeadState
{

	@Test
	public void testinitialize()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testEvaluate()
	{
		LifeForm bill = new Human(22, "bill", 22);
		ActionState as = new DeadState(bill);
	}


	
	@Test
	public void testRespawn() throws EnvironmentException
	{
		LifeForm bill = new Human(22, "bill", 22);
		LifeForm sandra = new Human(22, "sandra", 22);
		ActionState as = new DeadState(bill);
		
		sandra.mountAttack(bill);
		assertFalse(22 != as.myLF.getLifePoints());
		as.respawn();
		
		//test that the life is regenerated
		
		assertEquals(22, as.myLF.getLifePoints());
		//test that LF shows up in a new location
		
		//test that weapon is dropped
	}

}
