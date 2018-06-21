package ui;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;


public class TestGameDisplay
{
	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 20);
	}
	
	@Test
	public void test() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();
		
		LifeForm entity = new Human(2, "mock entity", 0);
		theWorld.addLifeForm(3, 2, entity);
		LifeForm human = new Human(0, "eddie cheddar", 20);
		theWorld.addLifeForm(0,0, human);
		LifeForm alien = new Alien("zaphod beeblebrox", 20);
		theWorld.addLifeForm(1,1, alien);
		
		GameDisplay gui = new GameDisplay();
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Create Cell Image Icon Correct For\nHuman(0,0) and Alien(1,1)\nDoes it look right?"));
		
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Map legend Displays Correctly\nAlien(Green Triangle)\nDoes it look right?"));	
	
	}

	
	
}
