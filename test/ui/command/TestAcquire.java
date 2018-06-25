/**
 * @Author Chandana G
 * Tests for lifeform picking up a weapon from the cell
 */

package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Weapon;

public class TestAcquire {

	Environment theWorld;
	@Test
	public void testAcquire() throws RException {

		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		Weapon cg = new ChainGun();
		theWorld.addWeapon(5, 5, cg);
		//entity.pickUpWeapon(cg);
		Acquire a = new Acquire();
		a.execute();
		assertEquals(cg, entity.getWeapon());
	}

}
