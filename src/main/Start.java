package main;
/**
 * 
 */

import environment.Environment;
import exceptions.RException;
import gameplay.Simulator;
import ui.GameDisplay;

/**
 * @author miles
 *
 */
public class Start
{

	/**
	 * @param args
	 * @throws RException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws RException, InterruptedException
	{
		//call simulator
		//create timers?
		//create GUI
		//add items to timers
		System.out.println("Welcome!");
		Environment.resetWorld();
		Environment.createWorld(15, 20);
		Simulator aiSim = new Simulator();
		//GameDisplay ui = new GameDisplay();
		
		aiSim.update(100);
		aiSim.update(100);
		aiSim.update(100);
		aiSim.update(100);
		aiSim.update(100);
		
		System.out.println("Bye!");
	}

}
