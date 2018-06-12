/** 
 * Weapon interface for limited functional access to GenericWeapon abstract class functionality (along with it's children).
 * 
 * Can issue a damage amount for use during attacks on other LifeForms and also provides access to timer, maxAmmo and MaxRange for 
 * calculation purposes to impact damage calculation by various means exeternal (from this class) means
 * 
 * @author Rob M, Chandana G
 */

package weapon;

public interface Weapon
{
	public int damage();
	public int getMaxAmmo();
	public int getMaxRange();
	void updateTime(int time);
}
