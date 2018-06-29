package ui;

import static org.junit.Assert.assertEquals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

public class TestGameDisplay
{
	GameDisplay gui;
	
	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 20);
	}
	
	@After
	public void cleanupGUI()
	{ 
		gui.dispose();
	}

	@Test
	public void testCreateHumansandAliens() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();

		LifeForm entity = new Human(2, "mock entity", 0);
		theWorld.addLifeForm(3, 2, entity);
		entity.rotate("East");
		theWorld.setActivePlayer(entity);

		LifeForm human = new Human(0, "eddie cheddar", 20);
		theWorld.addLifeForm(0, 0, human);
		human.rotate("West");

		LifeForm alien = new Alien("zaphod beeblebrox", 20);
		theWorld.addLifeForm(1, 1, alien);

		gui = new GameDisplay();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Create Cell Image Icon Correct For\nHuman facing West(0,0)\nand Alien facing North(1,1)\nand MockEntity facing East(3,2)\nDoes it look right?"));

	}

	@Test
	public void testCreateArmedEntity() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();

		LifeForm alien = new Alien("zaphod beeblebrox", 20);
		theWorld.addLifeForm(1, 1, alien);
		LifeForm human = new Human(0, "eddie cheddar", 20);
		theWorld.addLifeForm(0, 0, human);
		human.rotate("South");

		Weapon pistol = new Pistol();
		alien.pickUpWeapon(pistol);

		human.pickUpWeapon(pistol);

		gui = new GameDisplay();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Create Cell Image Icon Correct For\nArmed Human facing South(0,0)\nArmed Alien facing North(1,1) \nDoes it look right?"));
	}

	@Test
	public void testCreateWeapons() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();

		Weapon pistol = new Pistol();
		theWorld.addWeapon(7, 14, pistol);
		Weapon chain = new ChainGun();
		theWorld.addWeapon(7, 15, chain);
		Weapon cannon = new PlasmaCannon();
		theWorld.addWeapon(7, 16, cannon);
		Weapon pistol2 = new Pistol();
		theWorld.addWeapon(0, 14, pistol2);
		Weapon chain2 = new ChainGun();
		theWorld.addWeapon(0, 14, chain2);
		Weapon cannon2 = new PlasmaCannon();
		theWorld.addWeapon(2, 16, cannon2);
		Weapon pistol3 = new Pistol();
		theWorld.addWeapon(2, 16, pistol3);
		Weapon chain3 = new ChainGun();
		theWorld.addWeapon(1, 15, chain3);
		Weapon cannon3 = new PlasmaCannon();
		theWorld.addWeapon(1, 15, cannon3);

		gui = new GameDisplay();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Do you see all the possible combinations of weapons in various cells\nDoes it look right?"));
	}

	@Test
	public void testGUIUpdatesfromEnvt() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();

		LifeForm entity = new Human(2, "entity", 0);
		theWorld.addLifeForm(0, 0, entity);
		entity.rotate("East");
		theWorld.setActivePlayer(entity);
		gui = new GameDisplay();
		assertEquals(JOptionPane.YES_OPTION,
				JOptionPane.showConfirmDialog(null, "Do you see a human in 0,0 facing East?"));
		theWorld.playerDirection("South");
		
		gui.updateMap(); 
		assertEquals(JOptionPane.YES_OPTION,
				JOptionPane.showConfirmDialog(null, "Do you see a human in 0,0 facing South?"));

	}

	@Test
	public void testCreateLegend() throws InterruptedException, RException
	{
		gui = new GameDisplay();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Do you see a legend on the right\nIt should display Aliens, Humans, Weapons (3), Armed LifeForm.\nDoes it look right?"));
	}

	@Test
	public void testCreateAll() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();

		LifeForm entity = new Human(2, "mock entity", 0);
		theWorld.addLifeForm(3, 2, entity);
		entity.rotate("East");
		theWorld.setActivePlayer(entity);

		LifeForm human = new Human(0, "eddie cheddar", 20);
		theWorld.addLifeForm(0, 0, human);
		human.rotate("West");

		LifeForm alien = new Alien("zaphod beeblebrox", 20);
		theWorld.addLifeForm(1, 1, alien);

		Weapon pistol = new Pistol();
		alien.pickUpWeapon(pistol);
		theWorld.addWeapon(7, 14, pistol);
		Weapon chain = new ChainGun();
		theWorld.addWeapon(7, 15, chain);
		Weapon cannon = new PlasmaCannon();
		theWorld.addWeapon(7, 16, cannon);

		Weapon pistol2 = new Pistol();
		alien.pickUpWeapon(pistol);
		theWorld.addWeapon(0, 14, pistol2);
		Weapon chain2 = new ChainGun();
		theWorld.addWeapon(0, 14, chain2);
		Weapon cannon2 = new PlasmaCannon();
		theWorld.addWeapon(2, 16, cannon2);
		Weapon pistol3 = new Pistol();
		alien.pickUpWeapon(pistol);
		theWorld.addWeapon(2, 16, pistol3);
		Weapon chain3 = new ChainGun();
		theWorld.addWeapon(1, 15, chain3);
		Weapon cannon3 = new PlasmaCannon();
		theWorld.addWeapon(1, 15, cannon3);

		gui = new GameDisplay();
		// Thread.sleep(10000);
		// assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
		// "Create Cell Image Icon Correct For\nHuman, East(0,0) and Alien, North,
		// Armed(1,1)\nDoes it look right?"));

		// assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Map
		// legend Displays Correctly\nAlien(Green Triangle)\nDoes it look right?"));
	}

}

class MockGui extends JFrame
{
	MockGui()
	{
		setLayout(new BorderLayout());
	}

}

class MockInvoker implements ActionListener
{
	Environment theWorld = Environment.getWorld();

	GameDisplay UI;

	MockInvoker(GameDisplay UI)
	{
		this.UI = UI;
	}

	public JPanel generateInvoker()
	{
		/**
		 * Set up invoker layout
		 */
		JPanel invokerPanel = new JPanel(new GridLayout(1, 8));
		JButton[][] buttonArray = new JButton[1][8];

		buttonArray[0][0] = new JButton("West");
		// buttonArray[0][0].addActionListener(this);
		// buttonArray[0][0].setActionCommand("West");
		buttonArray[0][0].setBorder(BorderFactory.createLineBorder(Color.black));
		invokerPanel.add(buttonArray[0][0]);
		buttonArray[0][1] = new JButton("South");
		invokerPanel.add(buttonArray[0][1]);
		buttonArray[0][2] = new JButton("North");
		// buttonArray[0][2].addActionListener(this);
		// buttonArray[0][2].setActionCommand("North");
		invokerPanel.add(buttonArray[0][2]);
		buttonArray[0][3] = new JButton("East");
		// buttonArray[0][3].addActionListener(this);
		// buttonArray[0][3].setActionCommand("East");
		invokerPanel.add(buttonArray[0][3]);
		buttonArray[0][4] = new JButton("Pickup");
		invokerPanel.add(buttonArray[0][4]);
		buttonArray[0][5] = new JButton("Drop");
		invokerPanel.add(buttonArray[0][5]);

		buttonArray[0][6] = new JButton("Move");
		buttonArray[0][6].addActionListener(this);
		buttonArray[0][6].setActionCommand("Move");

		invokerPanel.add(buttonArray[0][6]);
		buttonArray[0][7] = new JButton("Attack");
		invokerPanel.add(buttonArray[0][7]);

		return invokerPanel;

	}

	@Override
	public void actionPerformed(ActionEvent button)
	{
		String action = button.getActionCommand();

		if (action == "Move")
		{
			System.out.println(action);
			theWorld.movePlayer();

		}
		try
		{
			UI.drawMap();
		}
		catch (RException e)
		{
			e.printStackTrace();
		}

	}
}
