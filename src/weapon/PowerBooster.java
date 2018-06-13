/**
 * 
 * Power Booster attachment will decorate (wrap and modify) the damage done by the weapon that it's wrapping.
 * 
 * Note: that weapon could be another attachment that wraps the initial weapon.  
 * 
 *@author Chandana G, Rob M
 */
package weapon;

public class PowerBooster extends Attachment
{
	GenericWeapon gw;
	PowerBooster(Weapon w) 
	{
		super(w);
		
	}
	/**
	 * Determine and return the damage to decorate the weapon damage with
	 */
	 public int damage()
	 
	  {
		 
		float x = (float)weapon.getCurrentAmmo()/weapon.getMaxAmmo();
		float y = 1 + x;
	    int damage = (int) ((int) ((float)weapon.damage() * y));
	    return damage;
	  
	  }
	 
}  
