package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import state.AI;
import ui.GameDisplay;

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

		

		// 
		// GameDisplay gui = new GameDisplay();
		//
		// assertEquals(JOptionPane.YES_OPTION,
		// JOptionPane.showConfirmDialog(null, "Do you see a map with LifeForms and guns
		// randomly strewn \n?"));
	}

	@Test // AI updates all the AIcontexts (action states)
	public void testAIcreation() throws RException
	{
		Environment theWorld = Environment.getWorld();
		Simulator simulator = new Simulator();

		assertTrue(simulator.lifeformAI != null);
	}

	// TODO __ sim updater
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
		LifeForm dude = dudeAI.getState().myLF;

		timer.timeChanged(); // manual trigger that can be automatically done by calling timer.run()

		assertEquals(dudeAI.noWeaponState, dudeAI.getState());
	}

	 @Test // time trigger updates AI
	 public void testTrueTimeUpdates() throws InterruptedException, RException
	 {
	
	 Environment theWorld = Environment.getWorld();
	
	 Simulator simulator = new Simulator();
	 SimpleTimer timer = new SimpleTimer();
	 timer.addTimeObserver(simulator);
	
	 GameDisplay gui = new GameDisplay();
	 MockTrigger x = new MockTrigger(gui);
	 timer.addTimeObserver(x);
	 timer.run();
	
	 assertEquals(JOptionPane.YES_OPTION,
	 JOptionPane.showConfirmDialog(null, "Do you see a map with LifeForms and guns randomly strewn?"));
	 }
}

class MockTrigger implements TimeObserver
{

	GameDisplay gui;

	MockTrigger(GameDisplay mygui)
	{
		gui = mygui;
	}

	@Override
	public void update(int time)
	{
		try
		{
			gui.updateMap();
			System.out.println(time);
		}
		catch (RException e)
		{
			e.printStackTrace();
		}

	}

}