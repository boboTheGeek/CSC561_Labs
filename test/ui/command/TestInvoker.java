/**
 * @Author Chandana G
 */

package ui.command;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Test;


import environment.Environment;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.GenericWeapon;
import weapon.Weapon;

public class TestInvoker
{
	//private static final int LEGAL_BUTTON_MASK = 0;
	Invoker invoke;
	
	
	@Test
	public void numberOfButtons() {
		int mouse = MouseInfo.getNumberOfButtons();
		assertEquals(5, mouse);
	}
	@Test // clear and setup the world before each test
	public void testReloadInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(10, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		theWorld.addLifeForm(2, 5, entity);
		theWorld.setActivePlayer(entity);
		GenericWeapon cg = new ChainGun(); 
		entity.pickUpWeapon(cg);
		Reload reload = new Reload();
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask1 = InputEvent.getMaskForButton(1); //InputEvent.BUTTON1_MASK;
		bot.mousePress(mask1);
		bot.delay(75);
		bot.mouseRelease(mask1);
		
		cg.fire();
	    cg.fire();
	    assertEquals(38, cg.getCurrentAmmo()); 
	    invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
	    assertEquals(40, cg.getCurrentAmmo());   
	}

	@Test
	public void testTurnDropInvoke() throws RException, InterruptedException, AWTException
	{
		
		
		Environment.resetWorld();
		Environment.createWorld(12, 14);
		Environment theWorld = Environment.getWorld();
		
		LifeForm entity2 = new MockLifeForm("Reethu", 20, 20);
		theWorld.addLifeForm(5, 8, entity2);
		theWorld.setActivePlayer(entity2);
		
		Weapon cg = new ChainGun();
		//theWorld.addWeapon(5, 5, cg);
		entity2.pickUpWeapon(cg);
		assertEquals(cg, entity2.getWeapon());
		Drop d = new Drop();
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask2 = InputEvent.getMaskForButton(2);
		//int mask4 = InputEvent.BUTTON1_DOWN_MASK;
		bot.mousePress(mask2);
		bot.delay(75);
		bot.mouseRelease(mask2);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertNull(entity2.getWeapon());
	
	}
	
	@Test
	public void testTurnAttackInvoke() throws RException, InterruptedException, AWTException
	{
		
		
		Environment.resetWorld();
		Environment.createWorld(12, 14);
		Environment theWorld = Environment.getWorld();
		
		LifeForm entity3 = new MockLifeForm("Anu", 20, 20);
		LifeForm entity4 = new MockLifeForm("Sana", 20, 20);
		theWorld.addLifeForm(5, 6, entity3);
		theWorld.addLifeForm(5, 7, entity4);
		theWorld.setActivePlayer(entity3);
		Weapon cg = new ChainGun();
		entity3.pickUpWeapon(cg);
		assertEquals(cg, entity3.getWeapon());
		Attack attack = new Attack();
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask3 = InputEvent.getMaskForButton(3);
		//int mask4 = InputEvent.BUTTON1_DOWN_MASK;
		bot.mousePress(mask3);
		bot.delay(75);
		bot.mouseRelease(mask3);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals(15, entity4.getLifePoints()); //Have to fix here
	
	}
	
	@Test
	public void testTurnAcquireInvoke() throws RException, InterruptedException, AWTException
	{
		
		
		Environment.resetWorld();
		Environment.createWorld(12, 14);
		Environment theWorld = Environment.getWorld();
		LifeForm entity5 = new MockLifeForm("Ravsie", 20, 20);
		theWorld.addLifeForm(5, 5, entity5);
		theWorld.setActivePlayer(entity5);
		Weapon cg = new ChainGun();
		entity5.pickUpWeapon(cg);
		Acquire a = new Acquire();
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask4 = InputEvent.getMaskForButton(4);
		//int mask4 = InputEvent.BUTTON1_DOWN_MASK;
		bot.mousePress(mask4);
		bot.delay(75);
		bot.mouseRelease(mask4);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals(cg, entity5.getWeapon());
	
	}
	
	
	@Test 
	public void testTurnNorthInvoke() throws RException, InterruptedException, AWTException
	{
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity6 = new MockLifeForm("Harshi", 20, 20);
		theWorld.addLifeForm(5, 5, entity6);
		theWorld.setActivePlayer(entity6);
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask5 = InputEvent.getMaskForButton(5);
		//int mask2 = InputEvent.BUTTON2_MASK;
		bot.mousePress(mask5);
		bot.delay(75);
		bot.mouseRelease(mask5);	
		assertEquals("North", entity6.getDirection());
		
	
	}
	/**@Test
	public void testTurnSouthInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity7 = new MockLifeForm("Fred", 20, 20);
		theWorld.addLifeForm(4, 5, entity7);
		theWorld.setActivePlayer(entity7);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask6 = InputEvent.getMaskForButton(6);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask6);
		bot.delay(75);
		bot.mouseRelease(mask6);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("South", entity7.getDirection());
	}
	
	@Test
	public void testTurnEastInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity8 = new MockLifeForm("Chand", 20, 20);
		theWorld.addLifeForm(6, 5, entity8);
		theWorld.setActivePlayer(entity8);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask7 = InputEvent.getMaskForButton(7);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask7);
		bot.delay(75);
		bot.mouseRelease(mask7);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("East", entity8.getDirection());
	}
	
	@Test
	public void testTurnWestInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity9 = new MockLifeForm("Rob", 20, 20);
		theWorld.addLifeForm(5, 7, entity9);
		theWorld.setActivePlayer(entity9);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask8 = InputEvent.getMaskForButton(8);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask8);
		bot.delay(75);
		bot.mouseRelease(mask8);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("West", entity9.getDirection());
		
	
	}
	
	@Test
	public void testMoveInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("Riya", 6, 8);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		theWorld.movePlayer();
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask8 = InputEvent.getMaskForButton(8);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask8);
		bot.delay(75);
		bot.mouseRelease(mask8);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		int[] y = theWorld.getLifeFormLocation(entity);
		assertEquals(2, y[0]);
	
	}
	*/
}	