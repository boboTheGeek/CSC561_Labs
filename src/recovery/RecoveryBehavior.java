/**
 * Interface for assigning the appropriate recovery behavior to appropriate LifeForms
 * 
 * @Author: Rob Miles
 */

package recovery;

public interface RecoveryBehavior
{
	/**
	 * Allows for the passing of parameters through the interface to calculate life
	 * points after one regenerative iteration
	 * 
	 * @param currentLife
	 *            -the lifeform's curent life points which will be the basis of the
	 *            recovery calculation
	 * @param maxLife
	 *            - used to determine the maximum level that the life points can
	 *            recover up to
	 * @return depending on the implmentation class selected returns the recovered
	 *         life point value
	 */
	public int calculateRecovery(int currentLife, int maxLife);
}