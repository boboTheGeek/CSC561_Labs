/**
 * This class is an implementation of RecoveryBehavior interface which 
 * doesn't impart any meanigful recovery of the instance variables calling upon the interface.
 * Other impmentation classes will change life points, which contrasts with this class.
 * 
 * @Author: Rob Miles
 */

package recovery;

public class RecoveryNone implements RecoveryBehavior
{
	
	public RecoveryNone(){
		return;
	}
	
	/**
	 * RecoveryNone class has no recovery so doesn't change calculateRecovery
	 * variables
	 * 
	 * @see recovery.RecoveryBehavior#calculateRecovery(int, int)
	 * 
	 * @param currentLife
	 *           - the number of life points remainig
	 * 
	 * @param maxLife
	 *           - the maximum number that can be recovered up-to (of life points)
	 *            
	 * @return what the current life points should be set to as a result of this recovery
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		return currentLife;
	}

}
