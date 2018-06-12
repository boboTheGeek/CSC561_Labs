package weapon;

public class GenericWeapon
{
	protected int baseDamage;
	protected int maxRange;
	protected int rateOfFire;
	protected int maxAmmo;
	protected int currentTime;
	protected int currentAmmo;

	public int damage()
	{
		return 0;
	}

	public void fire()
	{
		if(currentAmmo != 0)
		{
			currentAmmo--;
		}
	}

	public void reload()
	{
		currentAmmo = maxAmmo;
	}

	public void updateTime(int time)
	{
	}

	public int getMaxAmmo()
	{
		return maxAmmo;
	}

	public int getMaxRange()
	{
		return maxRange;
	}

}
