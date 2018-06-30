package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RException;
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
		Simulator simulator = new Simulator();

		assertTrue(simulator.lifeformAI != null);

		assertTrue(theWorld.getEntityLocations() != null);

		assertTrue(theWorld.getWeaponLocations() != null);

		@SuppressWarnings("unused")
		GameDisplay gui = new GameDisplay();

		assertEquals(JOptionPane.YES_OPTION,
				JOptionPane.showConfirmDialog(null, "Do you see a map with LifeForms and guns randomly strewn?"));
	}

	@Test // AI updates all the AIcontexts (action states)
	public void testAIcreation()
	{

	}
	//TODO __ sim updater
	@Test // time trigger updates AI
	public void testTimeUpdates() throws InterruptedException, RException
	{

		@SuppressWarnings("unused")
		Environment theWorld = Environment.getWorld();

		Simulator simulator = new Simulator();
		Timer timer = new SimpleTimer();
		timer.addTimeObserver(simulator);

		GameDisplay gui = new GameDisplay();

		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "thoughts?"));

		timer.timeChanged(); // manual trigger that can be automatically done by calling timer.run()

		gui.updateMap();
		assertEquals(JOptionPane.YES_OPTION,
				JOptionPane.showConfirmDialog(null, "Do you see a map with LifeForms and guns randomly strewn?"));

		// timer.timeChanged();
		//
		// //gui.updateMap();
		// assertEquals(JOptionPane.YES_OPTION,
		// JOptionPane.showConfirmDialog(null, "Dome lifeforms change location?"));
		//
		//
		// //timer.timeChanged();
		//
		// gui.updateMap();
		// assertEquals(JOptionPane.YES_OPTION,
		// JOptionPane.showConfirmDialog(null, "Did some lifeforms change location
		// again?"));
		//
	}

//	@Test // time trigger updates AI
//	public void testTrueTimeUpdates() throws InterruptedException, RException
//	{
//
//		Environment theWorld = Environment.getWorld();
//
//		Simulator simulator = new Simulator();
//		SimpleTimer timer = new SimpleTimer();
//		timer.addTimeObserver(simulator);
//
//		GameDisplay gui = new GameDisplay();
//		MockTrigger x = new MockTrigger(gui);
//		timer.addTimeObserver(x);
//		timer.run();
//		
//		assertEquals(JOptionPane.YES_OPTION,
//				JOptionPane.showConfirmDialog(null, "Do you see a map with LifeForms and guns randomly strewn?"));
//	}
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