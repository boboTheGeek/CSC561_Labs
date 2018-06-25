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

public class TestTurnWest {
	Environment theWorld;
	@Test
	public void testTurnWest() throws RException {
		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		TurnWest tw = new TurnWest();
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		tw.execute();		
		assertEquals("West", entity.getDirection());
	}

}
