/**
 * @author Chandana G
 * 
 * Tests for has weapon state
 */
package state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.GenericWeapon;

public class TestHasWeaponState
{

	  Environment theWorld;
	  LifeForm life, life1, life2, life3, life4;
	  /**
	   * Tests to check whether the current lifeform is dead
	   * @throws RException
	   */
	  @Test 
	  public void testToCheckIfLifeFormIsDead() throws RException 
	  { 
	    
	    Environment.resetWorld(); 
	    Environment.createWorld(20, 20); 
	    theWorld = Environment.getWorld(); 
	    /**
	     * setting lifeform life points to 0 to check whether the lifeform is dead and 
	     * see if the state changes to DeadSate
	     */
	    
	    life = new Human(20, "Ria", 0); 
	    theWorld.addLifeForm(5, 7, life); 
	    GenericWeapon w = new ChainGun();
		theWorld.addWeapon(5, 7, w);
		life.pickUpWeapon(w);

		AI myAi = new AI(life);
		ActionState oos = myAi.hasWeaponState;
		oos.evaluate();
		//check if lifeform's dead
		assertTrue(oos.ai.getState() instanceof DeadState);  
	  }
	  
	  /**
	   * Test for when player and target belong to same lifeform type
	   * and player attacks the target, an exception is thrown
	   * @throws RException
	   */
	  
	  @Test(expected = RException.class)
	  public void AttackOnSameType() throws RException 
	  { 
	    
	    Environment.resetWorld(); 
	    Environment.createWorld(20, 20); 
	    theWorld = Environment.getWorld(); 
	    /**
	     * setting lifeform life points to 0 to check whether the lifeform is dead and 
	     * see if the state changes to DeadSate
	     */
	    
	    life = new Human(20, "Ria", 20); 
	    theWorld.addLifeForm(5, 7, life);  
	    theWorld.playerDirection("North", life);
	    life1 = new Human(20, "Divya", 20); 
	    theWorld.addLifeForm(5, 9, life1);
	    life2 = new Human(20, "Divya", 20); 
	    theWorld.addLifeForm(5, 5, life2);
	    life3 = new Human(20, "Ami", 20); 
	    theWorld.addLifeForm(3, 7, life3);
	    life4 = new Human(20, "Reney", 20); 
	    theWorld.addLifeForm(7, 7, life4);

	    GenericWeapon w = new ChainGun();
	    theWorld.addWeapon(5, 7, w);
		life.pickUpWeapon(w);
		AI myAi = new AI(life);
		ActionState oos = myAi.hasWeaponState;
		oos.evaluate();
		//make sure no one gets hurt
		assertEquals(20, life1.getLifePoints()); 
		assertEquals(20, life2.getLifePoints()); 
		assertEquals(20, life3.getLifePoints()); 
		assertEquals(20, life4.getLifePoints()); 

		 
	  }
	  
	  /**
	   * Test for when player attacks its target and the player and the target 
	   * do not belong to same lifeform type
	   * @throws RException
	   */
	  @Test
	  public void AttackOnOtherLifeForm() throws RException 
	  { 
	    
	    Environment.resetWorld(); 
	    Environment.createWorld(20, 20); 
	    theWorld = Environment.getWorld(); 
	    
	    life = new Human(20, "Ria", 40); 
	    theWorld.addLifeForm(5, 7, life); 
	    theWorld.playerDirection("North", life);
	    theWorld.setActivePlayer(life);
	    
	    GenericWeapon w = new ChainGun();
		theWorld.addWeapon(5, 7, w);
		life.pickUpWeapon(w);
	    life3 = new Alien("Ray", 40); 
	    theWorld.addLifeForm(3, 7, life3); 
	    
		AI myAi = new AI(life);
		ActionState oos = myAi.hasWeaponState;
		oos.evaluate();
		/**
		 * Damage is calculated for the victim after the attack
		 */
		assertEquals(39, life3.getLifePoints()); 
	  }
	  
	  /**
	   * Test for when player doesn't have a target in his line of sight
	   * and chooses to change direction and finds a new cell to move into at random
	   * @throws RException
	   */
	  @Test
	  public void movePlayerAtRandom() throws RException
	  {
		 Environment.resetWorld(); 
		 Environment.createWorld(20, 20); 
		 theWorld = Environment.getWorld(); 
		    
		 life = new Human(20, "Ria", 20); 
		 theWorld.addLifeForm(5, 7, life); 
		 theWorld.playerDirection("North", life);
		 
		 GenericWeapon w = new ChainGun();
		 theWorld.addWeapon(5, 7, w);
		 life.pickUpWeapon(w);
		 
		    
		 AI myAi = new AI(life);
		 ActionState oos = myAi.hasWeaponState;
		 oos.evaluate();
		 if(HasWeaponState.val == true)
		 {
			int newloc[] = theWorld.getLifeFormLocation(life);
			assertEquals(2, newloc[0]);
			assertEquals(7, newloc[1]);
			assertTrue(life.getDirection() != "North");
		 }
		 else
		 {
			    int loc[] = theWorld.getLifeFormLocation(life);
				assertEquals(5, loc[0]);
				assertEquals(7, loc[1]);
				assertTrue(life.getDirection() == "North");
		 }
	  }
}

