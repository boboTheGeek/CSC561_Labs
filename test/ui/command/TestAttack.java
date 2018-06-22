package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Weapon;

public class TestAttack {

	Environment theWorld;
	@Test
	public void test() throws RException, EnvironmentException {

		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		//LifeForm entity2 = new MockLifeForm("Fred", 20, 20);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		Weapon cg = new ChainGun();
		theWorld.addLifeForm(5, 5, entity);
		entity.pickUpWeapon(cg);
		assertEquals(cg, entity.getWeapon());
		Attack attack = new Attack();
		attack.execute();
		assertEquals(15, entity2.getLifePoints()); //Have to fix here
	}

}
