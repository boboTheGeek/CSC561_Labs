/**
 * @author Chandana G
 * constructs the commands and sets up the Invoker with the commands it can use.
 */
package ui.command;

import javax.swing.JFrame;

public class InvokerBuilder
{
	 Invoker inv= new Invoker();
	 public void constructInvokerReload() 
	  { 
		Command x = new Reload();
	    inv.setCmd1(x); 

	  }
	 public JFrame constructInvokerDrop() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd2(new Drop()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerAttack() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd3(new Attack()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerAcquire() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd4(new Acquire()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerNorth() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd5(new TurnNorth()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerSouth() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd6(new TurnSouth()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerEast() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd7(new TurnEast()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerWest() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd8(new TurnWest()); 
	     
	    return inv; 
	  } 
	 public JFrame constructInvokerMove() 
	  { 
	    inv = new Invoker(); 
	    inv.setCmd9(new Move()); 
	     
	    return inv; 
	  }
}
