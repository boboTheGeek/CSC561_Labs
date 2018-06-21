package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Environment;
import lifeform.Alien;
import lifeform.Human;

public class GameDisplay extends JFrame
{

	JButton textButton1, textButton2, textButton3, textButton4, imageButton;
	JLabel textLabel, imageLabel;
	Environment theWorld;

	public GameDisplay() throws InterruptedException
	{
		theWorld = Environment.getWorld();

		setLayout(new BorderLayout());

		textLabel = new JLabel("Aliens Vs. Humans: --  a super awesome game by CSC561 designs");
		add("North", textLabel);
//		imageButton = new JButton(createImage());
//		add("West", imageButton);
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
		//human
		legendLabelArray[0][0] = new JLabel("human: ");
		legendPanel.add(legendLabelArray[0][0]);
		legendLabelArray[0][1] = new JLabel();
		legendLabelArray[0][1].setIcon(new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\EastArmed.png"));
		legendPanel.add(legendLabelArray[0][1]);
		//alien
		legendLabelArray[1][0] = new JLabel("alien: ");
		legendPanel.add(legendLabelArray[1][0]);
		legendLabelArray[1][1] = new JLabel();
		legendLabelArray[1][1].setIcon(new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\AEastArmed.png"));
		legendPanel.add(legendLabelArray[1][1]);
		//pistol
		legendLabelArray[2][0] = new JLabel("pistol: ");
		legendPanel.add(legendLabelArray[2][0]);
		legendLabelArray[2][1] = new JLabel();
		legendLabelArray[2][1].setIcon(new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\pistol.png"));
		legendPanel.add(legendLabelArray[2][1]);
		//chaingun
		legendLabelArray[3][0] = new JLabel("chaingun: ");
		legendPanel.add(legendLabelArray[3][0]);
		legendLabelArray[3][1] = new JLabel();
		legendLabelArray[3][1].setIcon(new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\chaingun.png"));
		legendPanel.add(legendLabelArray[3][1]);
		//plasmacannon
		legendLabelArray[3][0] = new JLabel("plasmacannon: ");
		legendPanel.add(legendLabelArray[3][0]);
		legendLabelArray[3][1] = new JLabel();
		legendLabelArray[3][1].setIcon(new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\cannon.png"));
		legendPanel.add(legendLabelArray[3][1]);
		
		
		 add("Center", centerPanel);
		 add("East", legendPanel);
		 pack();
		 setVisible(true);
		
		// labelArray[1][1].setOpaque(true);
		// labelArray[1][1].setBackground(Color.black);
		// labelArray[1][1].setIcon(new
		// ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\East.png"));
		//

		//
		// Thread.sleep(2000);
		// labelArray[1][1].setIcon(new
		// ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\North.png"));
	}

	private ImageIcon selectGraphic(int row, int col)
	{
		if (theWorld.getLifeForm(row, col) instanceof Human)
		{
			return new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\North.png");
		}
		else if (theWorld.getLifeForm(row, col) instanceof Alien)
		{
			return new ImageIcon("C:\\Users\\a008423\\eclipse-workspace\\GitPractice\\gamePix\\ANorth.png");
		}
		else
		{
			return createImage();
		}

	}

	public ImageIcon createImage()
	{
		BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = exampleImage.getGraphics();
		drawer.setColor(new Color(200, 200, 200));
		drawer.fillRect(0, 0, 50, 50);
		drawer.setColor(new Color(0, 255, 0));
		drawer.fillOval(20, 20, 10, 10);
		return new ImageIcon(exampleImage);
	}
}
