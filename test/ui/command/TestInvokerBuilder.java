package ui.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInvokerBuilder
{

	@Test
	public void test()
	{


		Invoker invoker = new Invoker();
		InvokerBuilder ib = new InvokerBuilder();
		
		ib.constructInvoker();  //this guy sets all the invoker.cmd# variables to new Reload(); or whatever
		
		assertTrue(invoker.cmd1 instanceof Reload());  //check that you're invoker.cmd1 instance variable points to the Reload() class (which is an extension of Command interface)
		
		
		//  repeat assertTrue for each of the buttons/invoker.cmdx instances
	}

}
