/**
 * @author - Chandana G

 * Tests for noWeaponState
 */
package state;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RException;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.Weapon;

public class TestHasNoWeapon
{
	  Environment theWorld; 
	  LifeForm life, life2, life3, life4; 
	
	  
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
	    //theWorld.setActivePlayer(life); 
		AI myAi = new AI(life);
		ActionState oos = myAi.noWeaponState;
		oos.evaluate();
		//check if lifeform's dead
		assertTrue(oos.ai.getState() instanceof DeadState);  
	  }
	  
	  /**
	   * Test to see if random method to pick a direction different from life form's
	   * current direction
	   * @throws RException 
	   */
	  @Test
	  public void testRandomDirectionPicker() throws RException
	  {
		  	Environment.resetWorld(); 
		    Environment.createWorld(20, 20); 
		    theWorld = Environment.getWorld();     
		    life2 = new Human(20, "Ria", 20); 
		    theWorld.addLifeForm(5, 7, life);
		    String direction = life2.getDirection();
		    AI myAi = new AI(life2);
			ActionState oos = myAi.noWeaponState;
			String randomPickedDirection = oos.getRandomDirectionToSearch();
			assertTrue(direction != randomPickedDirection);
	  }
	  
	  
	  /**
	   * Tests for a life form to pickup a weapon if there is a weapon in the current 
	   * cell it is in.
	   * Tests for when there is no weapon to pick up and 
	   @throws RException 
	   */
	  @Test
	  public void testWhenThereIsAWeaponForLifeFormToPickUp() throws RException
	  {
		  	Environment.resetWorld(); 
		    Environment.createWorld(20, 20); 
		    theWorld = Environment.getWorld();     
		    life3 = new Human(20, "D", 20); 
		    theWorld.addLifeForm(6, 7, life3);
		    System.out.println("in test 1" + "" + life3);
		    System.out.println("in test 2" + "" + life3.getLifePoints());
		    Weapon cg = new ChainGun();
		    theWorld.addWeapon(6, 7, cg);
		    AI myAi = new AI(life3);
			ActionState oos = myAi.noWeaponState;
			oos.evaluate();
			assertTrue(life3.getWeapon() == cg);
			
	  } 
	  /**
	   * When there is no weapon found in the current direction the player's facing
	   * he turns to another direction that is randomly chosen and goes on to search in that direction
	   * If he finds a weapon he transitions to hasWeaponState
	   * @throws RException
	   */
	  @Test
	  public void testWhenNoWeaponSearchInNewDirectionPicked() throws RException
	  {
		  	Environment.resetWorld(); 
		    Environment.createWorld(20, 20); 
		    theWorld = Environment.getWorld();     
		    life3 = new Human(20, "D", 20); 
		    theWorld.addLifeForm(6, 7, life3);
		    Weapon cg = new ChainGun();
		    //if picked random direction is North
		    theWorld.addWeapon(5, 7, cg);
		    //if picked random direction is East
		    theWorld.addWeapon(6, 9, cg);
		    //if picked random direction is West
		    theWorld.addWeapon(6, 4, cg);
		    //if picked random direction is South
		    theWorld.addWeapon(9, 7, cg);
		    AI myAi = new AI(life3);
			ActionState oos = myAi.noWeaponState;
			oos.evaluate();
			assertTrue(oos.ai.getState() instanceof HasWeaponState);
	  }
	  
	  /**
	   * When there is no weapon found in the current direction the player's facing
	   * he turns to another direction that is randomly chosen and goes on to search in that direction
	   * If he finds a weapon he stays in noWeaponState
	   * @throws RException
	   */
  	  @Test
	  public void testNoWeaponFoundSearchingInNewDirectionPicked() throws RException
	  {
		  	Environment.resetWorld(); 
		    Environment.createWorld(20, 20); 
		    theWorld = Environment.getWorld();     
		    life3 = new Human(20, "D", 20); 
		    theWorld.addLifeForm(6, 7, life3);
		    //Weapon cg = new ChainGun();
		    AI myAi = new AI(life3);
			ActionState oos = myAi.noWeaponState;
			oos.evaluate();
			//System.out.println("getState" + "" +oos.ai.getState());
			assertTrue(oos.ai.getState() instanceof NoWeaponState);
	  }
}
