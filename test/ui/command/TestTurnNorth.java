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

public class TestTurnNorth {
	Environment theWorld;

	
	@Test
	public void testTurnNorth() throws RException {
		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		TurnNorth tn = new TurnNorth();
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		tn.execute();		
		assertEquals("North", entity.getDirection());
		
		
		
	}

}
