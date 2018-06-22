package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestMove {

	Environment theWorld;
	@Test
	public void testMovement() throws RException {
		theWorld.resetWorld();
		theWorld.createWorld(12, 14);
		Environment env = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 6, 8);
		env.addLifeForm(5, 5, entity);
		env.setActivePlayer(entity);
		env.playerDirection("North");
		env.movePlayer();
		/**Here the current Location of the player is set to 5, 
		 * since the direction is set to North, the player moves up in the grid
		 * while changing columns while staying in the same row, so the currentLocation(x,y)
		 * of the player contains only the co-ordinate of the cell that changes.
		 * 
		 * Initially he was in the column 5, but after calling movePlayer() he shifts by 3 (the max speed)
		 * and is in the column 2
		 * considering there are no lifeforms already occupying the new location he has to move into.  
		 * LifeForm can pass through life other lifefforms in the cell
		 */
		int[] y = env.getLifeFormLocation(entity);
		assertEquals(2, y[0]);
	}

}
