/**
 * @author Chandana G
 * Tests for InvokerBuilder to see whether it's setting up the commands for Invoker correct
 */
package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInvokerBuilder
{

	@Test
	public void testforReload()
	{
		  Command cmd = new Reload();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerReload();  
		  assertTrue(invoker.cmd1 instanceof Reload);	     
	}

	@Test
	public void testforDrop()
	{
		  Command cmd = new Drop();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerDrop();  
		  assertTrue(invoker.cmd2 instanceof Drop); 
		     
	}
	@Test
	public void testforAttack()
	{
		  Command cmd = new Attack();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerAttack();  
		  assertTrue(invoker.cmd3 instanceof Attack); 
		     
	}
	@Test
	public void testforAcquire()
	{
		  Command cmd = new Acquire();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerAcquire();  
		  assertTrue(invoker.cmd4 instanceof Acquire); 
		     
	}
	@Test
	public void testforNorth()
	{
		  Command cmd = new TurnNorth();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerNorth();  
		  assertTrue(invoker.cmd5 instanceof TurnNorth); 
		     
	}
	@Test
	public void testforSouth()
	{
		  Command cmd = new TurnSouth();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerSouth();  
		  assertTrue(invoker.cmd6 instanceof TurnSouth); 
		     
	}
	@Test
	public void testforEast()
	{
		  Command cmd = new TurnEast();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerEast();  
		  assertTrue(invoker.cmd7 instanceof TurnEast); 
		     
	}
	@Test
	public void testforTurnWest()
	{
		  Command cmd = new Reload();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerWest();  
		  assertTrue(invoker.cmd8 instanceof TurnWest); 
		     
	}
	@Test
	public void testforMove()
	{
		  Command cmd = new Move();
		  Invoker invoker = new Invoker(); 
		  InvokerBuilder invokerbuild = new InvokerBuilder(); 
		  invokerbuild.constructInvokerMove();  
		  assertTrue(invoker.cmd9 instanceof Move); 
		     
	}
}

