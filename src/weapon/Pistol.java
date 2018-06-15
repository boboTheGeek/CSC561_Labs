
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
	public Pistol()
	{

		this.baseDamage = 10;
		this.maxRange = 25;
		this.rateOfFire = 2;
		this.maxAmmo = 10;
		this.currentAmmo = this.maxAmmo;
		this.shotCounter = this.rateOfFire;

	}

	/**
	 * 
	 */

	@Override
	public int damageCalculation()
	{
		return (int) ((int) (float) baseDamage * (((float) (maxRange - Range.distance + 5) / maxRange)));
	}

}
