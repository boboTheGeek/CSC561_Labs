/**
 * @author Rob Miles, Chandana G
 */

package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import state.AI;

public class TestSimulator
{

	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(12, 20);

	}

	@Test // populates the world full of lifeForms and weapons
	public void testinitialize() throws RException, InterruptedException
	{
		Environment theWorld = Environment.getWorld();
		@SuppressWarnings("unused")
		Simulator simulator = new Simulator();

		assertTrue(theWorld.getEntityLocations() != null);
		assertTrue(theWorld.getWeaponLocations() != null);
	}

	@Test // AI updates all the AIcontexts (action states)
	public void testAIcreation() throws RException, InterruptedException
	{
		@SuppressWarnings("unused")
		Environment theWorld = Environment.getWorld();
		Simulator simulator = new Simulator();

		assertTrue(simulator.lifeformAI != null);

		// set all the AI instances to DeadState
		for (AI ai : simulator.lifeformAI)
		{
			ai.changeToDeadState();
		}
		// Call the evaluation method to run it's loop on all AIs
		simulator.evaluate();

		// spot check to see that they've changed to the right state
		AI myai = simulator.lifeformAI.get(0);
		assertEquals(myai.noWeaponState, myai.getState());

		AI myai4 = simulator.lifeformAI.get(3);
		assertEquals(myai4.noWeaponState, myai4.getState());

		AI myai6 = simulator.lifeformAI.get(5);
		assertEquals(myai6.noWeaponState, myai6.getState());

	}

	@Test // time trigger updates AI
	public void testTimeUpdates() throws InterruptedException, RException
	{
		@SuppressWarnings("unused")
		Environment theWorld = Environment.getWorld();
		Simulator simulator = new Simulator();
		Timer timer = new SimpleTimer();
		timer.addTimeObserver(simulator);

		ArrayList<AI> aiList = simulator.getAI();
		AI dudeAI = aiList.get(1);
		dudeAI.changeToDeadState();
		@SuppressWarnings("unused")
		LifeForm dude = dudeAI.getState().myLF;

		timer.timeChanged(); // manual trigger that can be automatically done by calling timer.run()
	
		assertEquals(dudeAI.noWeaponState, dudeAI.getState());
	}


}

