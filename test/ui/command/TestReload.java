/**
 * @Author Chandana G
 * Tests for whether the current weapon the lifeform's holding is reloaded
 */

package ui.command;

import static org.junit.Assert.*;


import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.GenericWeapon;
import weapon.Weapon;

public class TestReload {
	
	Environment theWorld;
	LifeForm life = new LifeForm("bob", 40);

	//Tests for reload
	@Test
	public void testReload() throws RException {
		Environment.resetWorld();
		Environment.createWorld(6, 8);
		Environment env = theWorld.getWorld();
		GenericWeapon cg = new ChainGun(); 
		env.addLifeForm(3, 5, life);
		env.setActivePlayer(life);
		assertEquals(life, theWorld.itsMyTurn);
	    life.pickUpWeapon(cg);
	    Reload reload = new Reload();
	    assertEquals(cg, env.itsMyTurn.getWeapon());
	    
	    cg.fire();
	    cg.fire();
	    //After firing the currentAmmo of reload is reduced (maxAmmo = 40)
	    assertEquals(38, cg.getCurrentAmmo());
	    reload.execute();
	    //After reloading the weapon the currentAmmo is full reloaded to max
	    assertEquals(40, cg.getCurrentAmmo());
		
	}

}
