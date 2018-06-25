/**
 * @Author Chandana G
 * Tests for whether the button associated with a specific command executes when the button is clicked
 */

package ui.command;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import org.junit.Test;


import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.GenericWeapon;
import weapon.Weapon;

public class TestInvoker
{
	Invoker invoke;
	/**
	 * Test for active lifeform to turn north
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test 
	public void testTurnNorthInvoke() throws RException, InterruptedException, AWTException
	{
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd5(mock); 
	    inv.button5.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}
	/**
	 * Test for active lifeform to turn East
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testTurnEastInvoke() throws RException, InterruptedException, AWTException
	{
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd7(mock); 
	    inv.button7.doClick(); 
	    assertEquals("Clicked", mock.data); 
		}
	/**
	 * Test for active lifeform to turn South
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testTurnSouthInvoke() throws RException, InterruptedException, AWTException
	{
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd6(mock); 
	    inv.button6.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}
	/**
	 * Test for active lifeform to turn West
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testTurnWestInvoke() throws RException, InterruptedException, AWTException
	{
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd8(mock); 
	    inv.button8.doClick(); 
	    assertEquals("Clicked", mock.data); 
	
	}
	/**
	 * Test for lifeform to pickup the weapon
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testTurnAcquireInvoke() throws RException, InterruptedException, AWTException
	{
		
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd4(mock); 
	    inv.button4.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}
	/**
	 * Test for Lifeform to drop current weapon it's holding
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testTurnDropInvoke() throws RException, InterruptedException, AWTException
	{
		
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd2(mock); 
	    inv.button2.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}
	/**
	 * Test for a lifeform to move in the direction it's facing at its maximum speed
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testMoveInvoke() throws RException, InterruptedException, AWTException
	{
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd9(mock); 
	    inv.button9.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}
	/**
	 * Test for a life form to attack an other lifeform in it's life of sightif there exists one
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testTurnAttackInvoke() throws RException, InterruptedException, AWTException
	{
		
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd3(mock); 
	    inv.button3.doClick(); 
	    assertEquals("Clicked", mock.data); 
	
	}
	/**
	 * Test for the weapon lifeform's holding currently to reload
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void testReloadInvoke() throws RException, InterruptedException, AWTException
	{
		
		Invoker inv = new Invoker(); 
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd1(mock); 
	    inv.button1.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}

	
}	

class MockCommand implements Command{

	String data;
	@Override
	public void execute() throws RException, EnvironmentException 
	{
		// TODO Auto-generated method stub
		data = "Clicked";
		
	}
	
}