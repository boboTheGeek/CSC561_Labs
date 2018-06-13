/** 
 * Weapon interface for limited functional access to GenericWeapon abstract class functionality (along with it's children).
 * 
 * Can issue a damage amount for use during attacks on other LifeForms and also provides access to timer, maxAmmo and MaxRange for 
 * calculation purposes to impact damage calculation by various means exeternal (from this class) means
 * 
 * @author Rob M, Chandana G
 */

package weapon;

import gameplay.TimeObserver;

public interface Weapon extends TimeObserver 
{
	public int damage();

	public int getMaxAmmo();

	public int getMaxRange();

	void updateTime(int time);

	public int getAttachmentNumber();
	
	public int getCurrentAmmo();
	
	public void reload();
	
	
}
