/**
 * Timer mechanism 
 * 
 * @Author: Rob Miles
 */

package gameplay;

import java.util.ArrayList;

public class SimpleTimer extends Thread implements Timer
{
	protected ArrayList<TimeObserver> theObservers = new ArrayList<TimeObserver>();
	protected int currentTime;
	private int sleepVal;

	/**
	 * construct simple timer and set currentTime instance variable to 0
	 * @param  
	 */
	public SimpleTimer(int sleep)
	{
		currentTime = 0;
		sleepVal = sleep;
		
	}

	public SimpleTimer()
	{
		this(1000);
		currentTime = 0;
		
	}

	/**
	 * Add a new time observer to theObservers ArrayList. Once added, will get
	 * automatic time updates
	 * 
	 * @param newObserver
	 *            - is the TimeObserver instance that you want to add to the
	 *            ArrayList of items that will recieve automatic time updates
	 */

	public void addTimeObserver(TimeObserver newObserver)
	{
		theObservers.add(newObserver);
	}

	/**
	 * Remove observer from the ArrayList of objects expecting to recieve time
	 * updates
	 * 
	 * @param observer
	 *            - the observer that will be removed from the ArrayList of items to
	 *            recieve time updates (so it won't get those updates anymore)
	 */
	public void removeTimeObserver(TimeObserver observer)
	{
		theObservers.remove(observer);
	}

	/**
	 * update the time for each of the observers in the ArrayList that keeps track
	 * of the objects expecting time updates
	 */
	// @Override
	public void timeChanged()
	{
		for (TimeObserver x : theObservers)
		{
			x.updateTime(currentTime);
		}
	}

	/**
	 * return the last observer from theObservers
	 * 
	 * @return the last observer from theObervers ArrayList of time watchers
	 */
	public TimeObserver getObserver()
	{
		// TODO this is too strongly coupled
		int indx = theObservers.size() - 1; // subtract 1 since array starts at 0
		return theObservers.get(indx);
	}

	/**
	 * Getter to access the current time
	 * @return 
	 */
	public int getCurrentTime()
	{
		return currentTime;
	}
	/**
	 * the main timer time generator
	 * this guy will update the currentTime instance variable
	 * at an interval defined by sleepVal.  sleepVal will be set
	 * by the constructor as a passed parameter
	 */
	public void run()
	{
		for (int x = 0; x < 5; x++)
		{
			try
			{
				currentTime = x;
				Thread.sleep(sleepVal);			
			}
			catch (InterruptedException e)
			{
				System.out.println("Something bad happened.");
			}
		}
	}
}
