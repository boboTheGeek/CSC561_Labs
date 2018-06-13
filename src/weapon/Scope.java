/**
 * Scope attachment will decorate (wrap and modify) the damage done by the weapon that it's wrapping.
 * 
 * Note; that weapon could be another attachment that wraps the initial weapon.  
 * 
 * @author Rob Miles
 */

package weapon;

import environment.Range;

public class Scope extends Attachment
{

	Scope(Weapon w)
	{
		super(w);
	}

	public int damage()
	{

		int x = weapon.getMaxRange() - Range.distance;
		float y = 1 + (x / weapon.getMaxRange());
		float z = weapon.damage() * y;
		return (int) z;
	}

}
