/**
 * Implementation of RecoveryBehavior where LifeForm life points recouperate
 * at a fixed step value for each recovery phase (as opposed to recovering
 * at a dynamic or varying rate)
 * 
 * @Author: Rob Miles
 */

package recovery;

public class RecoveryLinear implements RecoveryBehavior
{
	private int recoveryStep;

	/**
	 * at initialization, set instance variable to be used for size of recovery step
	 * increments
	 * 
	 * @param step the size of increment for recovery
	 */
	public RecoveryLinear(int step)
	{
		recoveryStep = step;
	}

	/**
	 * Determines the intended recovery based on a simple step increase Will stay
	 * "dead" if life points are 0 and also won't allow life points to exceed the
	 * max life points
	 * 
	 * @see recovery.RecoveryBehavior#calculateRecovery(int, int)
	 * 
	 * @param currentLife
	 *            - the number of life points remainig
	 * 
	 * @param maxLife
	 *            - the maximum number that can be recovered up-to (of life points)
	 *            
	 * @return what the current life points should be set to as a result of this recovery
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		int proposedLP = currentLife + recoveryStep;

		if (currentLife == 0)
		{
			return currentLife;
		}
		else if (proposedLP >= maxLife)
		{
			currentLife = maxLife;
			return currentLife;
		}
		else
		{
			currentLife += recoveryStep;
			return currentLife;
		}

	}

}
