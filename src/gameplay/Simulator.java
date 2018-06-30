/**
 * this class handles the initialization of the AI and sets up the initial Environment map as well as calls update to the evaluate() 
 * method in all state clases as needed 
 * 
 * @Author Rob M, Chandana G
 */

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
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

public class Simulator implements TimeObserver
{
	ArrayList<AI> lifeformAI = new ArrayList<AI>();

	/**
	 * We start rocking and rolling here by setting an environment populated with a
	 * bunch of dudes, dudettes and aliens. Also, we scatter some weapons around to
	 * make it interesting.
	 * 
	 * @throws RException
	 */
	Simulator() throws RException
	{
		Environment theWorld = Environment.getWorld();
		int worldSize[] = theWorld.getEnvironmentDimensions();

		LifeForm ed = new Human((int) (Math.random() * 5), "ed", 40);
		AI edAI = new AI(ed);
		lifeformAI.add(edAI);

		LifeForm ned = new Human((int) (Math.random() * 5), "ed", 30);
		AI nedAI = new AI(ned);
		lifeformAI.add(nedAI);

		LifeForm fred = new Human((int) (Math.random() * 5), "ed", 41);
		AI fredAI = new AI(fred);
		lifeformAI.add(fredAI);

		LifeForm jed = new Human((int) (Math.random() * 5), "ed", 43);
		AI jedAI = new AI(jed);
		lifeformAI.add(jedAI);

		LifeForm snarf = new Alien("snarf", 25, new RecoveryLinear(1), 1);
		AI snarfAI = new AI(snarf);
		lifeformAI.add(snarfAI);

		LifeForm snarf0 = new Alien("snarf0", 25, new RecoveryFractional(1), 1);
		AI snarf0AI = new AI(snarf0);
		lifeformAI.add(snarf0AI);

		LifeForm snarf3 = new Alien("snarf3", 25, new RecoveryLinear(1), 1);
		AI snarf3AI = new AI(snarf3);
		lifeformAI.add(snarf3AI);

		LifeForm snarf4 = new Alien("snarf4", 25, new RecoveryNone(), 1);
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

	/**
	 * our timer will be able to trigger this method since we've made this an
	 * implementation of TimeObserver. When the SimpleTimer calls the update() on
	 * all it's observer list, this method gets triggered and in turn, passes the
	 * request along to evaluate(). Evaluate is the generic method that dispatches
	 * appropriate actions based on whatever state it is in.
	 */
	@Override
	public void update(int time)
	{
		try
		{
			evaluate();
		}
		catch (RException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * for all of the life forms that we've generated, and with their respective AI
	 * manager classes, call the evaluate method. This method is implemented in each
	 * of the state classes that we're interested in. Each of those states do a
	 * different evaluation and carry out some set of actions and transition to
	 * another state (if need be).
	 * 
	 * @throws RException
	 */
	public void evaluate() throws RException
	{
		for (AI ai : lifeformAI)
		{
			ai.evaluate();
		}

	}
	
	
	/**
	 * returns the array list instance variable containig the AIs
	 * @return
	 */
	public ArrayList<AI> getAI()
	{
		return lifeformAI;
	}

}
