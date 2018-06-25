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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.ws.spi.Invoker;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;



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
	JPanel centerP;
	JLabel[][] labelArray;
	/**
	 * constructor to generate game layout. Accesses the Environment varibles like
	 * map dimensions and also determines the LifeForms to display
	 * 
	 * @throws InterruptedException
	 * @throws RException
	 */
	public GameDisplay() throws InterruptedException, RException
	{
		theWorld = Environment.getWorld();

		setLayout(new BorderLayout());
		generateImageAssets();

		textLabel = new JLabel("Aliens Vs. Humans: --  a super awesome game by CSC561 designs");
		add("North", textLabel);

		MockInvoker i = new MockInvoker(this);
		centerP = drawMap();
		add("South", i.generateInvoker());
		add("Center", centerP);
		add("East", generateLegend());
		pack();
		setVisible(true);
	}

	/**
	 * creates a map layout using the dimensions of theWorld's cells[][] array of
	 * cells it will call another function to process the image that is displayed in
	 * that cell based on the required element for that cell.
	 * 
	 * @return JPanel of "cells" to make a map
	 * @throws RException
	 */
	public JPanel drawMap() throws RException
	{
		int[] x = theWorld.getEnvironmentDimensions();
		int rows = x[0];
		int columns = x[1];
		JPanel centerPanel = new JPanel(new GridLayout(rows, columns));
		labelArray = new JLabel[rows][columns];

		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < columns; c++)
			{
				labelArray[r][c] = new JLabel();
				labelArray[r][c].setIcon(selectGraphic(r, c));
				centerPanel.add(labelArray[r][c]);
			}
		}

		return centerPanel;
	}

	/**
	 * pick the graphic that will be displayed based on the the type of LifeForm
	 * that should be displayed. considers the direction, whether or weapon is in
	 * hand or what type of life form
	 * 
	 * @param row
	 * @param col
	 * @return graphic
	 * @throws RException
	 */
	private ImageIcon selectGraphic(int row, int col) throws RException
	{
		Weapon weapon = null;
		Weapon weapon2 = null;
		LifeForm entity = null;
		String entDir = null;

		if (theWorld.getLifeForm(row, col) != null)
		{
			entity = theWorld.getLifeForm(row, col);
			entDir = entity.getDirection();
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
		}

		if (theWorld.getWeapon(row, col) != null)
		{
			weapon = theWorld.getWeapon(row, col, 1);
			weapon2 = theWorld.getWeapon(row, col, 2);

			if (((weapon instanceof Pistol) && (weapon2 instanceof ChainGun))
					|| ((weapon2 instanceof Pistol) && (weapon instanceof ChainGun)))
			{
				return chaingunPistol;
			}
			else if (((weapon instanceof PlasmaCannon) && (weapon2 instanceof ChainGun))
					|| ((weapon2 instanceof PlasmaCannon) && (weapon instanceof ChainGun)))
			{
				return cannonChaingun;
			}
			else if (((weapon instanceof PlasmaCannon) && (weapon2 instanceof Pistol))
					|| ((weapon2 instanceof PlasmaCannon) && (weapon instanceof Pistol)))
			{
				return cannonPistol;
			}
			else if (weapon instanceof Pistol)
			{
				return pistol;
			}
			else if (weapon instanceof ChainGun)
			{
				return chaingun;
			}
			else if (weapon instanceof PlasmaCannon)
			{
				return plasmacannon;
			}

		}
		if ((weapon == null) && (entity == null))
		{
			return new ImageIcon("background.png");
		}
		return createImage();

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
	 * 
	 * Important Note: all of the assets need to be stored in the root folder of
	 * your project to get called correctly
	 */
	private void generateImageAssets()
	{

		HNorth = new ImageIcon("assets/North.png");
		HEast = new ImageIcon("assets/East.png");
		HWest = new ImageIcon("assets/West.png");
		HSouth = new ImageIcon("assets/South.png");
		ANorth = new ImageIcon("assets/ANorth.png");
		AEast = new ImageIcon("assets/AEast.png");
		AWest = new ImageIcon("assets/AWest.png");
		ASouth = new ImageIcon("assets/ASouth.png");
		HNorthArmed = new ImageIcon("assets/NorthArmed.png");
		HEastArmed = new ImageIcon("assets/EastArmed.png");
		HWestArmed = new ImageIcon("assets/WestArmed.png");
		HSouthArmed = new ImageIcon("assets/SouthArmed.png");
		ANorthArmed = new ImageIcon("assets/ANorthArmed.png");
		AEastArmed = new ImageIcon("assets/AEastArmed.png");
		AWestArmed = new ImageIcon("assets/AWestArmed.png");
		ASouthArmed = new ImageIcon("assets/ASouthArmed.png");
		pistol = new ImageIcon("assets/Pistol.png");
		chaingun = new ImageIcon("assets/chaingun.png");
		plasmacannon = new ImageIcon("assets/cannon.png");
		cannonChaingun = new ImageIcon("assets/cannonChaingun.png");
		chaingunPistol = new ImageIcon("assets/chaingunPistol.png");
		cannonPistol = new ImageIcon("assets/cannonPistol.png");
	}

	/**
	 * Creates the visuals for the Legend intended that provides visual queues for
	 * the user about what the various graphics mean in the UI
	 * 
	 * @return JPanel with a legend in it
	 */
	private JPanel generateLegend()
	{
		/**
		 * Set up legend
		 */
		JPanel legendPanel = new JPanel(new GridLayout(6, 2));
		legendPanel.setBackground(new Color(200, 200, 200));
		JLabel[][] legendLabelArray = new JLabel[6][2];
		// human
		legendLabelArray[0][0] = new JLabel("human");
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
		// armed guy
		legendLabelArray[5][0] = new JLabel("armed lifeform: ");
		legendPanel.add(legendLabelArray[5][0]);
		legendLabelArray[5][1] = new JLabel();
		legendLabelArray[5][1].setIcon(HSouthArmed);
		legendPanel.add(legendLabelArray[5][1]);

		return legendPanel;
	}

}


