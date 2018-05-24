/*
 * Interface for assigning the appropriate recovery behavior to appropriate LifeForms
 * Author: Rob Miles
 */

package recovery;

public interface RecoveryBehavior
{
	public int calculateRecovery(int currentLife, int maxLife);
}