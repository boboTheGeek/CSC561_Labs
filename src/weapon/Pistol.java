
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
	 * constructur sets the constants for instance variables related to Pistol.
	 * baseDamage = 10; maxRange = 25; rateOfFire = 2; maxAmmo = 10;
	 */
	Pistol()
	{

		this.baseDamage = 10;
		this.maxRange = 25;
		this.rateOfFire = 2;
		this.maxAmmo = 10;
		this.currentAmmo = this.maxAmmo;

	}
	
	/**
	 * Returns the amount of damage done for a Pistol
	 */
	@Override
	public int damage()
	{

		
		if ((currentAmmo == 0) || (maxRange < Range.distance)) {
			fire();
			return 0;
		} else {
			fire();
			return (int) ((int) (float) baseDamage * (((float)(maxRange - Range.distance + 5)/maxRange)));
		}
		
		
	}

}
