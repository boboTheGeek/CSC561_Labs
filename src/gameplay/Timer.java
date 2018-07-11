/**
 * Interface for SimpleTimer to use
 * 
 * @Author: Rob Miles
 */

package gameplay;

public interface Timer
{
	/**
	 * Interface will add an observer to list managed in SimpleTimer object so it
	 * can be automatically updated as SimpleTimer time canges
	 * 
	 * @param observer
	 */
	public void addTimeObserver(TimeObserver observer);

	/**
	 * Interface will remove an observer from list managed in SimpleTimer object it
	 * will then stop getting automatic updates from SimpleTimer subject
	 * 
	 * @param observer
	 */
	public void removeTimeObserver(TimeObserver observer);

	/**
	 * Interace can/will trigger a time change for all observers in registered list
	 * using this method
	 */
	public void timeChanged();
	
	/**
	 * starts the timer thread
	 */
	public void run();
	

}
