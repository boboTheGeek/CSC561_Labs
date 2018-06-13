package weapon;

import environment.Range;

public class PlasmaCannon extends GenericWeapon{
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
			return (int) ((int) (float) baseDamage * (((float) (currentAmmo) / maxAmmo)));
		}
		else
		{
			return 0;
		}

	}
	
}
