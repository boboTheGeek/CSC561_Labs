package weapon;

import environment.Range;

/**
 * @author a008423
 *
 */
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
