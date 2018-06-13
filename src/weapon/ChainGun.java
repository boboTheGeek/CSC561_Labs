package weapon;

import environment.Range;

/**
 * overrides the generic weapon abstract class to provide characteristic
 * features for instance variables as well as a specific override of the damage
 * method calculated on chain gun specific parameters
 * 
 * @author Chandana G (Pilot), Rob M (co-pilot)
 *
 */
public class ChainGun extends GenericWeapon
{

	/**
	 * constructor sets the constants for instance variables for Chain Gun.
	 * baseDamage = 15; maxRange = 30; rateOfFire = 4; maxAmmo = 40;
	 */
	ChainGun()
	{

		this.baseDamage = 15;
		this.maxRange = 30;
		this.rateOfFire = 4;
		this.maxAmmo = 40;
		this.currentAmmo = this.maxAmmo;
		this.shotCounter = this.rateOfFire;

	}

	/**
	 * Returns the amount of damage done by the ChainGun
	 * 
	 * Checks the range of the weapon, the further the range is the more damage the
	 * weapon does
	 * 
	 * checks that the shot counter is still valid (can only take so many shots per
	 * cycle
	 * 
	 * otherwise returns no damage
	 */
	@Override
	public int damageCalculation()
	{

		return (int) ((int) (float) baseDamage * (((float) (Range.distance) / maxRange)));

	}
}
