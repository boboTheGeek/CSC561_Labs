/**
 * @Author Chandana G
 * Tests to see whether the current lifeform attacks the other lifeform that is in its line of sight
 */

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

		Environment.resetWorld();
		Environment.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		LifeForm life2 = new MockLifeForm("Fred", 20, 20);
		theWorld.addLifeForm(5, 6, entity);
		theWorld.addLifeForm(5, 9, life2);
		theWorld.setActivePlayer(entity);
		Weapon cg = new ChainGun();
		entity.pickUpWeapon(cg);
		assertEquals(cg, entity.getWeapon());
		Command attack = new Attack();
		attack.execute();
		assertEquals(19, life2.getLifePoints()); 
	}

}
