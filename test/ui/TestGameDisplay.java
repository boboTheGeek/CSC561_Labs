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
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

public class TestGameDisplay
{
	@Before // clear and setup the world before each test
	public void testSetupWorld() throws RException
	{
		Environment.resetWorld();
		Environment.createWorld(10, 20);
	}

	@Test
	public void testCreateHumans() throws InterruptedException, RException
	{
		Environment theWorld = Environment.getWorld();

		LifeForm entity = new Human(2, "mock entity", 0);
		theWorld.addLifeForm(3, 2, entity);
		entity.rotate("East");

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
		GameDisplay gui = new GameDisplay();
		Thread.sleep(5000);
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Create Cell Image Icon Correct For\nHuman(0,0) and Alien(1,1)\nDoes it look right?"));

		// assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Map
		// legend Displays Correctly\nAlien(Green Triangle)\nDoes it look right?"));
	}

}
