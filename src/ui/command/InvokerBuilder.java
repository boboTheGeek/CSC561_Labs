/**
 * @author Chandana G
 * constructs the commands and sets up the Invoker with the commands it can use.
 */
package ui.command;

import javax.swing.JFrame;

public class InvokerBuilder
{
	 Invoker inv;
	 public JFrame constructInvoker()//Reload() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd1(new Reload()); 
	    inv.setCmd2(new Drop());
	    inv.setCmd3(new Attack());
	    inv.setCmd4(new Acquire());
	    inv.setCmd5(new TurnNorth());
	    inv.setCmd6(new TurnSouth());
	    inv.setCmd7(new TurnEast());
	    inv.setCmd8(new TurnWest());
	    inv.setCmd9(new Move());
	    return inv; 
	  }
}
