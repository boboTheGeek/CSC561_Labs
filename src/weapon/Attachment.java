
/**
* Abstract attachment class to manage weapon decorators (attachments that modify the Weapon's damage behavior)  
* @Author Rob M, Chandana G
*/
package weapon;

public abstract class Attachment implements Weapon
{
	protected Weapon weapon;
	int numberAttachments = 0;

	/**
	 * When creating the attachment object, pass in the weapon that you want to
	 * decorate (wrap). the weapon is stored in an instance variable we define in
	 * this Abstract Class level for all attachment subclasses
	 * 
	 * It will only allow 2 attachments to wrap/decorate the gun.
	 * 
	 * @param w
	 *            - the weapon object that we are going to decorate (modify it's
	 *            damage output)
	 */
	Attachment(Weapon w)
	{
		numberAttachments = w.getAttachmentNumber() + 1;
		if (numberAttachments <= 2)
		{
			weapon = w;
		}
		else if (w.getAttachmentNumber() + 1 == 3)
		{
			weapon = null;
		}
	}

	/**
	 * Allows access to pick up the number of attachments that are decorating the
	 * weapon. Max will be 2
	 */
	public int getAttachmentNumber()
	{

		return numberAttachments;

	}

	/**
	 * allows access to the child weapon's amo so it can be passed and used in
	 * decoration methods
	 */
	@Override
	public int getMaxAmmo()
	{

		return weapon.getMaxAmmo();
	}

	/**
	 * allows access to the child weapon's maxRange so it can be passed and used in
	 * decoration methods
	 */
	@Override
	public int getMaxRange()
	{

		return weapon.getMaxRange();
	}

	/**
	 * override for timer update, mainly for weapon classes to keep track of rates
	 */
	@Override
	public void update(int time)
	{

	}

	/**
	 * allows access ot the child weapon's current ammo so it can be used in
	 * decoration methods
	 */
	@Override
	public int getCurrentAmmo()
	{

		return weapon.getCurrentAmmo();
	}

	/**
	 * provides access to weapon's reload method that returns ammo to max ammo level
	 */
	@Override
	public void reload()
	{

	}

}
