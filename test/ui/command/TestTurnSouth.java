package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestTurnSouth {

	Environment theWorld;
	@Test
	public void testTurnSouth() throws RException {
		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		TurnSouth ts = new TurnSouth();
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		ts.execute();		
		assertEquals("South", entity.getDirection());
	}


}
