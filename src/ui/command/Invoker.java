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

	public JFrame Invoker() {
		
		JFrame jframe = new JFrame();
		setLayout(new BorderLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		jframe.add(panel);
		JButton button1 = new JButton();
		panel.add(button1);
		JLabel label = new JLabel("Reload");
		button1.add(label);
		button1.addActionListener(new ActionListener() 
		{

			Reload reload = new Reload();
			
			public void actionPerformed(ActionEvent e) {
				reload.execute();
			}
		});
		

    	JButton button2 = new JButton();
		panel.add(button2);
		label = new JLabel("North");
		button2.add(label);
		button2.addActionListener(new ActionListener() 
		{

			TurnNorth north = new TurnNorth();
			
			public void actionPerformed(ActionEvent e) {
				try {
					north.execute();
				} catch (RException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		JButton button3 = new JButton();
		panel.add(button3);
		label = new JLabel("South");
		button3.add(label);
		button3.addActionListener(new ActionListener() 
		{

			TurnSouth south = new TurnSouth();
			
			public void actionPerformed(ActionEvent e) {
				try {
					south.execute();
				} catch (RException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
	
	JButton button4 = new JButton();
	panel.add(button4);
	label = new JLabel("East");
	button4.add(label);
	button4.addActionListener(new ActionListener() 
	{

		TurnEast east = new TurnEast();
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				east.execute();
			} catch (RException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
/*
	JButton button6 = new JButton();
	panel.add(button6);
	label = new JLabel("West");
	button6.add(label);
	button6.addActionListener(new ActionListener() 
	{

		TurnWest west = new TurnWest();
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				west.execute();
			} catch (RException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});*/
	
	JButton button5 = new JButton();
	panel.add(button5);
	label = new JLabel("Drop");
	button5.add(label);
	button5.addActionListener(new ActionListener() 
	{

		Drop drop = new Drop();
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				drop.execute();
			} catch (RException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	JButton button6 = new JButton();
	panel.add(button6);
	label = new JLabel("West");
	button6.add(label);
	button6.addActionListener(new ActionListener() 
	{

		TurnWest west = new TurnWest();
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				west.execute();
			} catch (RException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	jframe.setVisible(true);
	jframe.pack();
	return jframe;
	}
}
		/**JButton button4 = new JButton();
		panel.add(button4);
		button4.addActionListener(new ActionListener() 
		{

			TurnEast east = new TurnEast();
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					east.execute();
				} catch (RException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton button5 = new JButton();
		panel.add(button5);
		button5.addActionListener(new ActionListener() 
		{

			TurnWest west = new TurnWest();
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					west.execute();
				} catch (RException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton button6 = new JButton();
		panel.add(button6);
		button6.addActionListener(new ActionListener() 
		{

			Drop drop = new Drop();
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					drop.execute();
				} catch (RException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton button7 = new JButton();
		panel.add(button7);
		button7.addActionListener(new ActionListener() 
		{

			Acquire acquire = new Acquire();
			@Override
			public void actionPerformed(ActionEvent e) {
				acquire.execute();
			}
		});
		
		JButton button8 = new JButton();
		panel.add(button8);
		button8.addActionListener(new ActionListener() 
		{

			Attack attack = new Attack();
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					attack.execute();
				} catch (RException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EnvironmentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		*/
		



	




