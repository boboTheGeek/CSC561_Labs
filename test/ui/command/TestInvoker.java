package ui.command;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;


import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import ui.GameDisplay;
import weapon.ChainGun;
import weapon.GenericWeapon;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

public class TestInvoker
{
	Invoker invoke;
	
	
	
	@Test
	public void numberOfButtons() {
		int mouse = MouseInfo.getNumberOfButtons();
		assertEquals(6, mouse);
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
		//bot.delay(75);
		bot.mouseRelease(mask1);
		
		cg.fire();
	    cg.fire();
	    assertEquals(38, cg.getCurrentAmmo()); 
	    invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
	    assertEquals(40, cg.getCurrentAmmo());   
	}

	
	@Test // clear and setup the world before each test
	public void testTurnNorthInvoke() throws RException, InterruptedException, AWTException
	{
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		theWorld.addLifeForm(5, 5, entity);
		theWorld.setActivePlayer(entity);
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask2 = InputEvent.getMaskForButton(2);
		//int mask2 = InputEvent.BUTTON2_MASK;
		bot.mousePress(mask2);
		//bot.delay(75);
		bot.mouseRelease(mask2);	
		assertEquals("North", entity.getDirection());
		
	
	}
	@Test
	public void testTurnSouthInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity1 = new MockLifeForm("Fred", 20, 20);
		theWorld.addLifeForm(4, 5, entity1);
		theWorld.setActivePlayer(entity1);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask3 = InputEvent.getMaskForButton(3);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask3);
		//bot.delay(75);
		bot.mouseRelease(mask3);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("South", entity1.getDirection());
	}
	
	@Test
	public void testTurnEastInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity2 = new MockLifeForm("Chand", 20, 20);
		theWorld.addLifeForm(6, 5, entity2);
		theWorld.setActivePlayer(entity2);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask4 = InputEvent.getMaskForButton(4);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask4);
		//bot.delay(75);
		bot.mouseRelease(mask4);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("East", entity2.getDirection());
	}
	
/**	@Test
	public void testTurnWestInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity3 = new MockLifeForm("Rob", 20, 20);
		theWorld.addLifeForm(5, 7, entity3);
		theWorld.setActivePlayer(entity3);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask5 = InputEvent.getMaskForButton(5);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask5);
		//bot.delay(75);
		bot.mouseRelease(mask5);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("West", entity3.getDirection());
		
	
	}**/
	@Test
	public void testTurnDropInvoke() throws RException, InterruptedException, AWTException
	{
		
		
		Environment.resetWorld();
		Environment.createWorld(12, 14);
		Environment theWorld = Environment.getWorld();
		
		LifeForm entity4 = new MockLifeForm("Reethu", 20, 20);
		theWorld.addLifeForm(5, 8, entity4);
		theWorld.setActivePlayer(entity4);
		
		Weapon cg = new ChainGun();
		//theWorld.addWeapon(5, 5, cg);
		entity4.pickUpWeapon(cg);
		assertEquals(cg, entity4.getWeapon());
		Drop d = new Drop();
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask5 = InputEvent.getMaskForButton(5);
		//int mask4 = InputEvent.BUTTON1_DOWN_MASK;
		bot.mousePress(mask5);
		//bot.delay(75);
		bot.mouseRelease(mask5);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertNull(entity4.getWeapon());
	
	}
	
	@Test
	public void testTurnWestInvoke() throws RException, InterruptedException, AWTException
	{
		
		Environment.resetWorld();
		Environment.createWorld(20, 20);
		Environment theWorld = Environment.getWorld();
		LifeForm entity3 = new MockLifeForm("Rob", 20, 20);
		theWorld.addLifeForm(5, 7, entity3);
		theWorld.setActivePlayer(entity3);
		
		int mouse = MouseInfo.getNumberOfButtons();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask6 = InputEvent.getMaskForButton(6);
		//int mask3 = InputEvent.BUTTON3_MASK;
		bot.mousePress(mask6);
		//bot.delay(75);
		bot.mouseRelease(mask6);	
		invoke = new Invoker();
		invoke.Invoker();
		Thread.sleep(10000);
		assertEquals("West", entity3.getDirection());
	}
}	


//	@Test // clear and setup the world before each test
	
	/*Environment.resetWorld();
		Environment.createWorld(10, 20);
		Environment theWorld = Environment.getWorld();
		int mouse = MouseInfo.getNumberOfButtons();
		Invoker invoke = new Invoker();
		invoke.Invoker();
		Robot bot = new Robot();
		bot.mouseMove(10,10);
		int mask1 = InputEvent.getMaskForButton(1);
		bot.mousePress(mask1);
		bot.delay(75);
		bot.mouseRelease(mask1);
		GenericWeapon cg = new ChainGun(); 
		assertEquals(40, cg.getCurrentAmmo());
		
		
		Environment.resetWorld();
		Environment.createWorld(10, 20);
		theWorld = Environment.getWorld();
		int mask2 = InputEvent.getMaskForButton(3);
		bot.mousePress(mask2);
		bot.delay(75);
		bot.mouseRelease(mask2);
		LifeForm entity = new MockLifeForm("bob", 20, 20);
		assertEquals("North", entity.getDirection());
		
		Environment.resetWorld();
		Environment.createWorld(10, 20);
		theWorld = Environment.getWorld();
		int mask3 = InputEvent.getMaskForButton(3);
		bot.mousePress(mask3);
		bot.delay(75);
		bot.mouseRelease(mask3);
		LifeForm entity2 = new MockLifeForm("bob", 20, 20);
		assertEquals("South", entity2.getDirection());
		
		Environment.resetWorld();
		Environment.createWorld(10, 20);
		theWorld = Environment.getWorld();
		int mask4 = InputEvent.getMaskForButton(4);
		bot.mousePress(mask4);
		bot.delay(75);
		bot.mouseRelease(mask4);
		LifeForm entity3 = new MockLifeForm("Fred", 20, 20);
		assertEquals("East", entity3.getDirection());
		//bot.mousePress(InputEvent.BUTTON1_MASK);
		//add time between press and release or the input event system may 
		//not think it is a click
		//try{Thread.sleep(250);}catch(InterruptedException e){}
		//bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}*/
	
	//}
//}
