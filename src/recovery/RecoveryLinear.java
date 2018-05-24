/*
 * Implementation of RecoveryBehavior where LifeForm life points recouperate
 * at a fixed step value for each recovery phase (as opposed to recovering
 * at a dynamic or varying rate)
 * 
 * Author: Rob Miles
 */
package recovery;

public class RecoveryLinear implements RecoveryBehavior
{
	private int recoveryStep;
	/*
	 * at initialization, set instance variable to be used for
	 * size of recovery step increments
	 */
	public RecoveryLinear(int step) {
		
		recoveryStep = step;
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see recovery.RecoveryBehavior#calculateRecovery(int, int)
	 * 
	 * overriding calculateRecovery method from interface to provide linear
	 * implementation of it
	 * 
	 * @param currentLife the number of life points remainig
	 * 
	 * @param maxLife the maximum number that can be recovered up-to (of life
	 * points)
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		if ((currentLife + recoveryStep) > maxLife) {
			currentLife = maxLife;
			return currentLife;
		} else {
			currentLife += recoveryStep;
			return currentLife;
			
		}
	}

}
