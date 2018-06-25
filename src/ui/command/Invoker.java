package ui.command;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	public JFrame Invoker() 
	{
		
		JFrame jframe = new JFrame();
		setLayout(new BorderLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		jframe.add(panel);
		JButton button1 = new JButton("Reload");
		panel.add(button1);
		//JLabel label = new JLabel("Reload");
		//button1.add(label);
		
		button1.addActionListener(new ActionListener() 
		{

			Command reload = new Reload();
			
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "Reload") 
				{
					try {
						reload.execute();
					} catch (RException | EnvironmentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	
	
		JButton button2 = new JButton("Drop");
		panel.add(button2);
		
		button2.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				Drop drop = new Drop();
				if(command == "Drop") 
				{
					try 
					{
						drop.execute();
					
					} 
					catch (RException e1) 
					{
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	
		JButton button3 = new JButton("Attack");
		panel.add(button3);
		button3.addActionListener(new ActionListener() 
		{

			Attack attack = new Attack();
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "Attack") 
				{
					try 
					{
						attack.execute();
					}
					catch (RException e1) 
					{
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (EnvironmentException e1) 
					{
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton button4 = new JButton("Pickup");
		panel.add(button4);
		button4.addActionListener(new ActionListener() 
		{

			Acquire acquire = new Acquire();
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "Reload") 
				{
					acquire.execute();
				}
			}
		});
	
		JButton button5 = new JButton("North");
		panel.add(button5);
		button5.addActionListener(new ActionListener() 
		{

			TurnNorth north = new TurnNorth();
		
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "North") 
				{
					try 
				
					{
						north.execute();
					}
					catch (RException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		//Tests not working for below methods
	
		JButton button6 = new JButton("South");
		panel.add(button6);
		button6.addActionListener(new ActionListener() 
		{

			TurnSouth south = new TurnSouth();
		
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "South") 
				{
					try 
					{
						south.execute();
					}
					catch (RException e1) 
					{
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});


		JButton button7 = new JButton("East");
		panel.add(button7);
		button7.addActionListener(new ActionListener() 
		{

			TurnEast east = new TurnEast();
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "East") 
				{	
					try 
					{
						east.execute();
					} 
					catch (RException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JButton button8 = new JButton("West");
		panel.add(button8);
		button8.addActionListener(new ActionListener() 
		{

			TurnWest west = new TurnWest();
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "West") 
				{
					try 
					{
						west.execute();
					
					}
					catch (RException e1) 
					{
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton button9 = new JButton("Move");
		panel.add(button9);
		button9.addActionListener(new ActionListener() 
		{
			Move move = new Move();
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				if(command == "Move") 
				{
					move.execute();
				}
			}
		});
		
		
		jframe.setVisible(true);
		jframe.pack();
		return jframe;
	}
}

		



	




