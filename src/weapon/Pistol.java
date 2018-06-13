
/**
 * overrides the generic weapon abstract class to provide characteristic features for instance variables as well
 * as a specific override of the damage method calculated on pistol specific parameters
 * 
 * @author Rob M (Pilot), Chandana G (co-pilot)
 *
 */

package weapon;

import environment.Range;

public class Pistol extends GenericWeapon
{

	/**
	 * constructor sets the constants for instance variables related to Pistol.
	 * baseDamage = 10; maxRange = 25; rateOfFire = 2; maxAmmo = 10;
	 */
	Pistol()
	{

		this.baseDamage = 10;
		this.maxRange = 25;
		this.rateOfFire = 2;
		this.maxAmmo = 10;
		this.currentAmmo = this.maxAmmo;
		this.shotCounter = this.rateOfFire;

	}

	/**
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
	public int damage()
	{

		if ((currentAmmo == 0) || (maxRange < Range.distance))
		{
			fire();
			return 0;
		}
		else if (shotCounter > 0)
		{
			fire();
			return (int) ((int) (float) baseDamage * (((float) (maxRange - Range.distance + 5) / maxRange)));
		}
		else
		{
			return 0;
		}

	}

}
