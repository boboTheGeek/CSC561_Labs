/**
 * Recovery implementation that implements RecoveryFractional interface
 * Aliens with fractional recovery only recover a certain fraction of their
 * current life points. The fraction amount is set when the RecoveryFractional
 * class is first created.
 * In the case of a fractional life point always round up.
 * 
 * @Author: Rob Miles
 */

package recovery;

public class RecoveryFractional implements RecoveryBehavior
{
	private double percentRecovery;

	/**
	 * Constructor for Fractional recovery implementation of Recovery Behavior
	 * 
	 * @param percent
	 *            is the value that will be divided with lifepoints to determine the
	 *            fractional recovery step
	 */
	public RecoveryFractional(double percent)
	{
		percentRecovery = 1 / percent;
	}

	/**
	 * Determines the intended recovery based on a fractional recovery basis. it
	 * uses the recovery instance value to determine what the fraction (of remaining
	 * life points) will be returned to life points. Will stay "dead" if life points
	 * are 0 and also won't allow life points to exceed the max life points. The
	 * fractional recovery value calculated will be rounded up to the nearest whole
	 * life point.
	 * 
	 * @see recovery.RecoveryBehavior#calculateRecovery(int, int)
	 * 
	 * @param currentLife
	 *           - the number of life points remainig
	 * 
	 * @param maxLife
	 *          -  the maximum number that can be recovered up-to (of life points)
	 *            
	 * @return what the current life points should be set to as a result of this recovery            
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		float floatVal = (float) (currentLife * percentRecovery);
		int recoveryStep = (int) Math.ceil(floatVal);
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
