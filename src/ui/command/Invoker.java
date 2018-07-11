/**
 * @Author Chandana G
 * Creates the buttons and associates the command actions to the buttons 
 * Keeps tracks of commands and calls on them.
 * 
 */

package ui.command;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import ui.command.Command;

public class Invoker extends JFrame
{	

	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	 Command cmd1, cmd2, cmd3, cmd4, cmd5, cmd6, cmd7, cmd8, cmd9; 
	public Invoker() 
	{
		
		JFrame jframe = this;
		jframe.setLayout(new BorderLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		jframe.add(panel);
		button1 = new JButton("Reload");
		panel.add(button1);
		
		button1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					
				 try { 
			          cmd1.execute(); 
			        } catch (RException e1) { 
			           
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			          e1.printStackTrace(); 
			        } 
			}
		});
	
	
		button2 = new JButton("Drop");
		panel.add(button2);
		
		button2.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd2.execute(); 
			        } catch (RException e1) { 
			           
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			          
			          e1.printStackTrace(); 
			        } 
				}
			
		});
	
		button3 = new JButton("Attack");
		panel.add(button3);
		button3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd3.execute(); 
			        } catch (RException e1) { 
			         
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			         
			          e1.printStackTrace(); 
			        } 
			}
		});
		
		button4 = new JButton("Pickup");
		panel.add(button4);
		button4.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd4.execute(); 
			        } catch (RException e1) { 
			        
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			        
			          e1.printStackTrace(); 
			        } 
			}
		});
	
		button5 = new JButton("North");
		panel.add(button5);
		button5.addActionListener(new ActionListener() 
		{

			TurnNorth north = new TurnNorth();
		
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd5.execute(); 
			        } catch (RException e1) { 
			          
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			          
			          e1.printStackTrace(); 
			        } 
			}
		});
	
		button6 = new JButton("South");
		panel.add(button6);
		button6.addActionListener(new ActionListener() 
		{
		
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd6.execute(); 
			        } catch (RException e1) { 
			           
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			         
			          e1.printStackTrace(); 
			        } 
			}
		});


		button7 = new JButton("East");
		panel.add(button7);
		button7.addActionListener(new ActionListener() 
		{

			TurnEast east = new TurnEast();
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd7.execute(); 
			        } catch (RException e1) { 
			          
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			          
			          e1.printStackTrace(); 
			        } 
			}
		});

		button8 = new JButton("West");
		panel.add(button8);
		button8.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd8.execute(); 
			        } catch (RException e1) { 
			           
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			          
			          e1.printStackTrace(); 
			        } 
			}
		});
		
		button9 = new JButton("Move");
		panel.add(button9);
		button9.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try { 
			          cmd9.execute(); 
			        } catch (RException e1) { 
			           
			          e1.printStackTrace(); 
			        } catch (EnvironmentException e1) { 
			           
			          e1.printStackTrace(); 
			        } 
			}
		});		


		jframe.setVisible(true);
		jframe.pack();
		//return jframe;
	}
	
	
	  public void setCmd1(Command cmd) 
	  { 
	    cmd1 = cmd; 
	  } 
	  public void setCmd2(Command cmd) 
	  { 
	    cmd2 = cmd; 
	  } 
	  public void setCmd3(Command cmd) 
	  { 
	    cmd3 = cmd; 
	  } 
	  public void setCmd4(Command cmd) 
	  { 
	    cmd4 = cmd; 
	  } 
	  public void setCmd5(Command cmd) 
	  { 
	    cmd5 = cmd; 
	  } 
	  public void setCmd6(Command cmd) 
	  { 
	    cmd6 = cmd; 
	  } 
	  public void setCmd7(Command cmd) 
	  { 
	    cmd7 = cmd; 
	  } 
	  public void setCmd8(Command cmd) 
	  { 
	    cmd8 = cmd; 
	  } 
	  public void setCmd9(Command cmd) 
	  { 
	    cmd9 = cmd; 
	  } 
}

		



	




