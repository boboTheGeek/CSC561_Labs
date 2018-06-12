/**
 * Interface for TimeObserver to be used by classes like LifeForm
 * 
 * @Author: Rob Miles
 */

package gameplay;

public interface TimeObserver
{
	
	/**
	 * Interace can/will trigger a time change for all observers in registered list
	 * using this method
	 * 
	 * @param time - is the time sent from SimpleTimer subject to all observers in it's list
	 */
	public void updateTime(int time);	

}
