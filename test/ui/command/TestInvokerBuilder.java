/**
 * @author Chandana G
 * Tests for InvokerBuilder to see whether it's setting up the commands for Invoker correct
 */
package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInvokerBuilder
{

	 InvokerBuilder invokerbuild = new InvokerBuilder();
	@Test
	public void testforReload()
	{
		  //Command cmd = new Reload();
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd1 instanceof Reload);	     
	}

	@Test
	public void testforDrop()
	{
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd2 instanceof Drop); 
		     
	}
	@Test
	public void testforAttack()
	{
	
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd3 instanceof Attack); 
		     
	}
	@Test
	public void testforAcquire()
	{
 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd4 instanceof Acquire); 
		     
	}
	@Test
	public void testforNorth()
	{

		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd5 instanceof TurnNorth); 
		     
	}
	@Test
	public void testforSouth()
	{
 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd6 instanceof TurnSouth); 
		     
	}
	@Test
	public void testforEast()
	{

		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd7 instanceof TurnEast); 
		     
	}
	@Test
	public void testforTurnWest()
	{

		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd8 instanceof TurnWest); 
		     
	}
	@Test
	public void testforMove()
	{

		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd9 instanceof Move); 
		     
	}
}

