/*
 * This class is an implementation of RecoveryBehavior interface which 
 * doesn't impart any meanigful recovery of the instance variables calling upon the interface.
 * Other impmentation classes will change life points, which contrasts with this class.
 * 
 * Author: Rob Miles
 */

package recovery;

public class RecoveryNone implements RecoveryBehavior
{
	/*
	 * 
	 * @see recovery.RecoveryBehavior#calculateRecovery(int, int)
	 * 
	 * RecoveryNone class has no recovery so doesn't change calculateRecovery
	 * variables
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
