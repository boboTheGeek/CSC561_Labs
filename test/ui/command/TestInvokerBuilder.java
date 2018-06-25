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
		  Command cmd = new Reload();
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd1 instanceof Reload);	     
	}

	@Test
	public void testforDrop()
	{
		  Command cmd = new Drop(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd2 instanceof Drop); 
		     
	}
	@Test
	public void testforAttack()
	{
		  Command cmd = new Attack();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd3 instanceof Attack); 
		     
	}
	@Test
	public void testforAcquire()
	{
		  Command cmd = new Acquire();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd4 instanceof Acquire); 
		     
	}
	@Test
	public void testforNorth()
	{
		  Command cmd = new TurnNorth();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd5 instanceof TurnNorth); 
		     
	}
	@Test
	public void testforSouth()
	{
		  Command cmd = new TurnSouth();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd6 instanceof TurnSouth); 
		     
	}
	@Test
	public void testforEast()
	{
		  Command cmd = new TurnEast();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd7 instanceof TurnEast); 
		     
	}
	@Test
	public void testforTurnWest()
	{
		  Command cmd = new Reload();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd8 instanceof TurnWest); 
		     
	}
	@Test
	public void testforMove()
	{
		  Command cmd = new Move();
		  Invoker invoker = new Invoker(); 
		  invokerbuild.constructInvoker();
		  assertTrue(invokerbuild.inv.cmd9 instanceof Move); 
		     
	}
}

