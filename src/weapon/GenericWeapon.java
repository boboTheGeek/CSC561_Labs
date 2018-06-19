/**
 * Generic weapon is an abstract class that implements the Weapon interface.  

 * The common instance characteristic variables are  baseDamage, maxRange, 
 * rateOfFire, maxAmmo, currentTime and currentAmmo.  Most are set by the constructors from the extending weapon classes
 * 
 * damage is the main method which will be overridden by each weapon type to provide a unique amount of damage
 * 
 * @author Rob Miles, Chandana G 
 *
 */
package weapon;

public abstract class GenericWeapon implements Weapon
{
	protected int baseDamage;
	protected int maxRange;
	protected int rateOfFire;
	protected int maxAmmo;
	protected int currentTime;
	protected int currentAmmo;
	protected int shotCounter;
	private int attachmentNumber = 0;

	/**
	 * Returns the amount of damage caused by the weapon at hand (pun intended :)
	 *
	 *
	 * Returns the amount of damage done for a Pistol
	 * 
	 * Checks that there is ammo left and that the weapon is in range to do damage
	 * 
	 * checks that the shot counter is still valid (can only take so many shots per
	 * cycle
	 * 
	 * otherwise returns no damage
	 */
	@Override
	public int damage(int distance)
	{

		if ((currentAmmo == 0) || (maxRange < distance))
		{
			fire();
			return 0;
		} else if (shotCounter > 0)
		{
			fire();
			return damageCalculation(distance);
		} else
		{
			return 0;
		}

	}

	/**
	 * Method to be called typically by damage to decrease (aka, use up) one round
	 * of ammo when a shot is "fired" by damage. Only decreases ammo when there is
	 * more than 0 in the clip.
	 */
	public void fire()
	{
		if (currentAmmo != 0)
		{
			currentAmmo--;
			shotCounter--;
		}
	}

	/**
	 * upon calling this method, the ammo of the weapon is refilled up to the
	 * maximum (maxAmmo)
	 */
	public void reload()
	{
		currentAmmo = maxAmmo;
	}

	/**
	 * Allows a weapon instance to have a time counter which will be used to
	 * implement the firing rate
	 * 
	 * when time is updated, the shot counter is reset to the starting point for
	 * another round
	 * 
	 * @param time
	 *            just what it sounds like
	 */

	public void updateTime(int time)
	{
		currentTime = time;
		shotCounter = rateOfFire;
	}

	/**
	 * returns the maximum amount of ammo the weapon can hold set by the local
	 * instance variable
	 */
	public int getMaxAmmo()
	{
		return maxAmmo;
	}

	/**
	 * returns the maximum range that the weapon can shoot/reach set by the local
	 * instance variable
	 */
	public int getMaxRange()
	{
		return maxRange;
	}

	public int getAttachmentNumber()
	{
		return attachmentNumber;
	}

	/**
	 * to be overridden by weapon implementations
	 * 
	 * @return the requested damage
	 */
	public int damageCalculation(int distance)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCurrentAmmo()
	{

		return currentAmmo;

	}
}
