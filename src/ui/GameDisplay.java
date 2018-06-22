/**
 * Generate the UI by using characteristics of the environment and active lifeforms
 * 
 * @author Rob Miles
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

public class GameDisplay extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -23524222967984828L;
	JButton textButton1, textButton2, textButton3, textButton4, imageButton;
	JLabel textLabel, imageLabel;
	Environment theWorld;
	ImageIcon HNorth, HEast, HWest, HSouth, ANorth, AEast, AWest, ASouth;
	ImageIcon pistol, chaingun, plasmacannon, cannonPistol, chaingunPistol, cannonChaingun;
	ImageIcon HNorthArmed, HEastArmed, HWestArmed, HSouthArmed, ANorthArmed, AEastArmed, AWestArmed, ASouthArmed;

	/**
	 * constructor to generate game layout. Accesses the Environment varibles like
	 * map dimensions and also determines the LifeForms to display
	 * 
	 * @throws InterruptedException
	 */
	public GameDisplay() throws InterruptedException
	{
		theWorld = Environment.getWorld();

		setLayout(new BorderLayout());
		generateImageAssets();
		textLabel = new JLabel("Aliens Vs. Humans: --  a super awesome game by CSC561 designs");
		add("North", textLabel);
		imageLabel = new JLabel(createImage());
		add("South", imageLabel);
		textButton4 = new JButton("Legend Area");
		add("East", textButton4);

		int[] x = theWorld.getEnvironmentDimensions();
		int rows = x[0];
		int columns = x[1];
		JPanel centerPanel = new JPanel(new GridLayout(rows, columns));
		JLabel[][] labelArray = new JLabel[rows][columns];
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < columns; c++)
			{

				labelArray[r][c] = new JLabel();
				labelArray[r][c].setIcon(selectGraphic(r, c));
				centerPanel.add(labelArray[r][c]);
			}
		}

		/**
		 * Set up legend
		 */
		JPanel legendPanel = new JPanel(new GridLayout(6, 2));
		JLabel[][] legendLabelArray = new JLabel[6][2];
		// human
		legendLabelArray[0][0] = new JLabel("human: ");
		legendPanel.add(legendLabelArray[0][0]);
		legendLabelArray[0][1] = new JLabel();
		legendLabelArray[0][1].setIcon(HEast);
		legendPanel.add(legendLabelArray[0][1]);
		// alien
		legendLabelArray[1][0] = new JLabel("alien: ");
		legendPanel.add(legendLabelArray[1][0]);
		legendLabelArray[1][1] = new JLabel();
		legendLabelArray[1][1].setIcon(AWest);
		legendPanel.add(legendLabelArray[1][1]);
		// pistol
		legendLabelArray[2][0] = new JLabel("pistol: ");
		legendPanel.add(legendLabelArray[2][0]);
		legendLabelArray[2][1] = new JLabel();
		legendLabelArray[2][1].setIcon(pistol);
		legendPanel.add(legendLabelArray[2][1]);
		// chaingun
		legendLabelArray[3][0] = new JLabel("chaingun: ");
		legendPanel.add(legendLabelArray[3][0]);
		legendLabelArray[3][1] = new JLabel();
		legendLabelArray[3][1].setIcon(chaingun);
		legendPanel.add(legendLabelArray[3][1]);
		// plasmacannon
		legendLabelArray[4][0] = new JLabel("plasmacannon: ");
		legendPanel.add(legendLabelArray[4][0]);
		legendLabelArray[4][1] = new JLabel();
		legendLabelArray[4][1].setIcon(plasmacannon);
		legendPanel.add(legendLabelArray[4][1]);
		// plasmacannon
		legendLabelArray[5][0] = new JLabel("armed lifeform: ");
		legendPanel.add(legendLabelArray[5][0]);
		legendLabelArray[5][1] = new JLabel();
		legendLabelArray[5][1].setIcon(HSouthArmed);
		legendPanel.add(legendLabelArray[5][1]);
		
		MockInvoker invoker = new MockInvoker();
		add("South", invoker.generateInvoker());
		add("Center", centerPanel);
		add("East", legendPanel);
		pack();
		setVisible(true);
	}

	/**
	 * pick the graphic that will be displayed based on the the type of LifeForm
	 * that should be displayed. considers the direction, whetehr or wapon is in
	 * hand or what type of life form
	 * 
	 * @param row
	 * @param col
	 * @return graphic
	 */
	private ImageIcon selectGraphic(int row, int col)
	{
		LifeForm entity;
		if (theWorld.getLifeForm(row, col) == null)
		{
			return new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\background.png");
		}
		else
		{
			entity = theWorld.getLifeForm(row, col);
		}
		String entDir = entity.getDirection();

		if (entDir == "North")
		{

			if ((entity instanceof Human))
			{
				if (entity.getWeapon() != null)
				{
					return HNorthArmed;
				}
				else
				{
					return HNorth;
				}
			}
			else if (entity instanceof Alien)
			{
				if (entity.getWeapon() != null)
				{
					return ANorthArmed;
				}
				else
				{
					return ANorth;
				}
			}
		}

		if (entDir == "East")
		{
			if ((entity instanceof Human))
			{
				if (entity.getWeapon() != null)
				{
					return HEastArmed;
				}
				else
				{
					return HEast;
				}
			}
			else if (entity instanceof Alien)
			{
				if (entity.getWeapon() != null)
				{
					return AEastArmed;
				}
				else
				{
					return AEast;
				}
			}

		}
		if (entDir == "South")
		{
			if ((entity instanceof Human))
			{
				if (entity.getWeapon() != null)
				{
					return HSouthArmed;
				}
				else
				{
					return HSouth;
				}
			}
			else if (entity instanceof Alien)
			{
				if (entity.getWeapon() != null)
				{
					return ASouthArmed;
				}
				else
				{
					return ASouth;
				}
			}

		}
		if (entDir == "West")
		{
			if ((entity instanceof Human))
			{
				if (entity.getWeapon() != null)
				{
					return HWestArmed;
				}
				else
				{
					return HWest;
				}
			}
			else if (entity instanceof Alien)
			{
				if (entity.getWeapon() != null)
				{
					return AWestArmed;
				}
				else
				{
					return AWest;
				}
			}

		}
		return new ImageIcon(getClass().getResource("assets\background.png"));

	}

	/**
	 * generate some generic image icon that can be used
	 * 
	 * @return
	 */
	public ImageIcon createImage()
	{
		BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = exampleImage.getGraphics();
		drawer.setColor(new Color(200, 200, 200));
		drawer.fillRect(0, 0, 50, 50);
		drawer.setColor(new Color(0, 75, 0));
		drawer.fillOval(20, 20, 10, 10);
		return new ImageIcon(exampleImage);
	}

	/**
	 * create all of the images as instance variables that can be used by the
	 * various UI methods
	 */
	private void generateImageAssets()
	{
		String path = "C:\\git\\CSC561_Labs\\assets\\";
		HNorth = new ImageIcon("North.png");
		HEast = new ImageIcon(path + "East.png");
		HWest = new ImageIcon("West.png");
		HSouth = new ImageIcon(path + "South.png");
		ANorth = new ImageIcon(path + "ANorth.png");
		AEast = new ImageIcon(path + "AEast.png");
		AWest = new ImageIcon(path + "AWest.png");
		ASouth = new ImageIcon(path + "ASouth.png");
		HNorthArmed = new ImageIcon(path + "NorthArmed.png");
		HEastArmed = new ImageIcon(path + "EastArmed.png");
		HWestArmed = new ImageIcon(path + "WestArmed.png");
		HSouthArmed = new ImageIcon(path + "SouthArmed.png");
		ANorthArmed = new ImageIcon(path + "ANorthArmed.png");
		AEastArmed = new ImageIcon(path + "AEastArmed.png");
		AWestArmed = new ImageIcon(path + "AWestArmed.png");
		ASouthArmed = new ImageIcon(path + "ASouthArmed.png");
		pistol = new ImageIcon(path + "Pistol.png");
		chaingun = new ImageIcon(path + "chaingun.png");
		plasmacannon = new ImageIcon(path + "cannon.png");
		cannonChaingun = new ImageIcon(path + "cannonChaingun.png");
		chaingunPistol = new ImageIcon(path + "chaingunPistol.png");
		cannonPistol = new ImageIcon(path + "cannonPistol.png");
	}
}

class MockInvoker implements ActionListener
{
	Environment theWorld = Environment.getWorld();
	
	public JPanel generateInvoker()
	{
		/**
		 * Set up invoker layout
		 */
		JPanel invokerPanel = new JPanel(new GridLayout(1, 8));
		JButton[][] buttonArray = new JButton[1][8];

		buttonArray[0][0] = new JButton("West");
		buttonArray[0][0].addActionListener(this);
		buttonArray[0][0].setActionCommand("West");
		invokerPanel.add(buttonArray[0][0]);
		buttonArray[0][1] = new JButton("South");
		invokerPanel.add(buttonArray[0][1]);
		buttonArray[0][2] = new JButton("North");
		invokerPanel.add(buttonArray[0][2]);
		buttonArray[0][3] = new JButton("East");
		invokerPanel.add(buttonArray[0][3]);
		buttonArray[0][4] = new JButton("Pickup");
		invokerPanel.add(buttonArray[0][4]);
		buttonArray[0][5] = new JButton("Drop");
		invokerPanel.add(buttonArray[0][5]);
		buttonArray[0][6] = new JButton("Move");
		buttonArray[0][0].addActionListener(this);
		invokerPanel.add(buttonArray[0][6]);
		buttonArray[0][7] = new JButton("Attack");
		invokerPanel.add(buttonArray[0][7]);

		return invokerPanel;

	}

	@Override
	public void actionPerformed(ActionEvent button)
	{
		String action = button.getActionCommand();
		if(action == "West") {
			System.out.println(action);
			try
			{
				theWorld.playerDirection(action);
			}
			catch (RException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
