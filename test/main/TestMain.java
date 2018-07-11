package main;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;

import gameplay.SimpleTimer;
import gameplay.Simulator;
import gameplay.TimeObserver;
import gameplay.Timer;
import ui.GameDisplay;

public class TestMain
{

	@Test // time trigger updates AI
	public void testTrueTimeUpdates() throws InterruptedException, RException
	{
		Environment.resetWorld();
		Environment.createWorld(12, 20);
		Environment theWorld = Environment.getWorld();

		Simulator simulator = new Simulator();
		Timer timer = new SimpleTimer();
		timer.addTimeObserver(simulator);
		GameDisplay gui = new GameDisplay();
		MockTrigger x = new MockTrigger(gui);
		Timer quicktimer = new SimpleTimer(100);
		quicktimer.addTimeObserver(x);
		timer.run();
		quicktimer.run();

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
		} catch (RException e)
		{
			e.printStackTrace();
		}

	}

}