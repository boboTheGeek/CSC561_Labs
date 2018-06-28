package gameplay;

import java.util.ArrayList;

import environment.Environment;
import exceptions.RException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;
import state.AI;
import state.ActionState;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

public class Simulator
{
	ArrayList<AI> lifeformAI = new ArrayList<AI>();

	Simulator() throws RException
	{
		Environment theWorld = Environment.getWorld();
		int worldSize[] = theWorld.getEnvironmentDimensions();

		LifeForm ed = new Human(2, "ed", 40);
		AI edAI = new AI(ed);
		lifeformAI.add(edAI);

		LifeForm ned = new Human(3, "ed", 30);
		AI nedAI = new AI(ned);
		lifeformAI.add(nedAI);

		LifeForm fred = new Human(1, "ed", 41);
		AI fredAI = new AI(fred);
		lifeformAI.add(fredAI);

		LifeForm jed = new Human(2, "ed", 43);
		AI jedAI = new AI(jed);
		lifeformAI.add(jedAI);

		LifeForm snarf = new Alien("snarf", 25, new RecoveryLinear(1), 1);
		AI snarfAI = new AI(snarf);
		lifeformAI.add(snarfAI);

		LifeForm snarf0 = new Alien("snarf0", 25, new RecoveryFractional(1), 1);
		AI snarf0AI = new AI(snarf0);
		lifeformAI.add(snarf0AI);

		LifeForm snarf1 = new Alien("snarf1", 25, new RecoveryNone(), 1);
		AI snarf1AI = new AI(snarf1);
		lifeformAI.add(snarf1AI);

		LifeForm snarf2 = new Alien("snarf2", 25, new RecoveryNone(), 1);
		AI snarf2AI = new AI(snarf2);
		lifeformAI.add(snarf2AI);

		LifeForm snarf3 = new Alien("snarf3", 25, new RecoveryLinear(1), 1);
		AI snarf3AI = new AI(snarf3);
		lifeformAI.add(snarf3AI);

		LifeForm snarf4 = new Alien("snarf4", 25, new RecoveryFractional(1), 1);
		AI snarf4AI = new AI(snarf4);
		lifeformAI.add(snarf4AI);

		for (AI ai : lifeformAI)
		{
			int row = (int) (Math.random() * worldSize[0]);
			int col = (int) (Math.random() * worldSize[1]);
			int x[] =
			{ row, col };
			while (theWorld.getEntityLocations().containsValue(x))
			{
				row = (int) (Math.random() * worldSize[0]);
				col = (int) (Math.random() * worldSize[1]);
				x[0] = row;
				x[1] = col;
			}
			LifeForm lf = ai.getState().myLF;
			theWorld.addLifeForm(row, col, lf);
		}

		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add(new Pistol());
		weapons.add(new Pistol());
		weapons.add(new ChainGun());
		weapons.add(new PlasmaCannon());
		weapons.add(new ChainGun());
		weapons.add(new PlasmaCannon());
		weapons.add(new Pistol());
		weapons.add(new Pistol());
		
		for (Weapon w : weapons)
		{
			int row = (int) (Math.random() * worldSize[0]);
			int col = (int) (Math.random() * worldSize[1]);
			int x[] =
			{ row, col };
			while (theWorld.getEntityLocations().containsValue(x))
			{
				row = (int) (Math.random() * worldSize[0]);
				col = (int) (Math.random() * worldSize[1]);
				x[0] = row;
				x[1] = col;
			}

			theWorld.addWeapon(row, col, w);
		}
	}

	public void evaluate()
	{
		for (AI ai : lifeformAI)
		{
			ai.evaluate();
		}
	}

	public void update()
	{
	}

}
