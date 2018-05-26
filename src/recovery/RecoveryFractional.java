package recovery;

public class RecoveryFractional implements RecoveryBehavior
{
	private double percentRecovery;
	
	public RecoveryFractional(double percent)
	{
		//TODO look closer at fractional ratio, type, rounding, what it factors against
		percentRecovery = 1/percent;
	}
	
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		int recoveryStep = (int) (currentLife*percentRecovery);
		
		System.out.println(percentRecovery);
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
