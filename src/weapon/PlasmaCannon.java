/**
 * overrides the generic weapon abstract class to provide characteristic
 * features for instance variables as well as a specific override of the damage
 * method calculated on plasma cannon specific parameters
 * 
 * @author Chandana G, Rob M 
 *
 */
package weapon;

public class PlasmaCannon extends GenericWeapon
{
	/**
	 * constructor sets the constants for instance variables for Plasma Cannon.
	 * baseDamage = 50; maxRange = 20; rateOfFire = 1; maxAmmo = 4;
	 */
	PlasmaCannon()
	{

		this.baseDamage = 50;
		this.maxRange = 20;
		this.rateOfFire = 1;
		this.maxAmmo = 4;
		this.currentAmmo = this.maxAmmo;
		this.shotCounter = this.rateOfFire;

	}

	/**
	 * Returns the amount of damage done for a Plasma Cannon
	 * 
	 * Checks that there is ammo left and that the weapon is in range to do damage
	 * 
	 * checks that the shot counter is still valid (can only take so many shots per
	 * cycle
	 * 
	 * otherwise returns no damage
	 */
	@Override
	public int damageCalculation()
	{

		return (int) ((int) (float) baseDamage * (((float) (currentAmmo) / maxAmmo)));

	}

}
