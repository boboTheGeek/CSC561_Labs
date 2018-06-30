package state;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.LifeForm;

public class TestAI
{

	@Test
	public void testInit() throws RException

	{
		Environment.resetWorld();
		Environment.createWorld(2, 4);

		LifeForm roo = new Alien("roo", 15);
		AI ai = new AI(roo);
		assertEquals(ai.noWeaponState, ai.getState());
		assertTrue(ai.noWeaponState instanceof NoWeaponState);
		assertTrue(ai.hasWeaponState instanceof HasWeaponState);
		assertTrue(ai.outOfAmmoState instanceof OutOfAmmoState);
		assertTrue(ai.deadState instanceof DeadState);

	}
	@Test
	public void testSetters() throws RException

	{
		Environment.resetWorld();
		Environment.createWorld(2, 4);

		LifeForm roo = new Alien("roo", 15);
		AI ai = new AI(roo);
		
		assertTrue(ai.getState() instanceof NoWeaponState);
		
		ai.changeToHasWeaponState();
		assertTrue(ai.getState() instanceof HasWeaponState);
		
		ai.changeToNoAmmoState();
		assertTrue(ai.getState() instanceof OutOfAmmoState);
		
		ai.changeToDeadState();
		assertTrue(ai.getState() instanceof DeadState);

	}


}
