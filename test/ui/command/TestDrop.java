/**
 * @Author Chandana G
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

public class TestDrop {

	Environment theWorld;
	@Test
	public void testDrop() throws RException {
		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		Weapon cg = new ChainGun();
		theWorld.addLifeForm(5, 5, entity);
		entity.pickUpWeapon(cg);
		assertEquals(cg, entity.getWeapon());
		Drop d = new Drop();
		d.execute();
		assertNull(entity.getWeapon());

	}

}
