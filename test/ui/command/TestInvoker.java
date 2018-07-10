/**
 * @Author Chandana G
 * Tests for whether the button associated with a specific command executes when the button is clicked
 */

package ui.command;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Test;

import exceptions.EnvironmentException;
import exceptions.RException;

public class TestInvoker
{
	Invoker inv = new Invoker(); 

	/**
	 * Test for active lifeform to turn north
	 * @throws RException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test 
	public void testTurnNorthInvoke() throws RException, InterruptedException, AWTException
	{
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
		
	    MockCommand mock = new MockCommand(); 
	    inv.setCmd1(mock); 
	    inv.button1.doClick(); 
	    assertEquals("Clicked", mock.data); 
	}
	@After
	public void cleanup()
	{ 
		inv.dispose();
	}
	
}	

class MockCommand implements Command{

	String data;
	@Override
	public void execute() throws RException, EnvironmentException 
	{
		data = "Clicked";
		
	}
	
}