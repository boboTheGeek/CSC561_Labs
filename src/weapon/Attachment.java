/**
 * Abstract attachment class to manage weapon decorators (attachments that modify the Weapon's damage behavior)
 * 
 * @Author Rob M
 */

package weapon;

public abstract class Attachment
{
	protected Weapon weapon;
	int numberAttachments = 0;

	/**
	 * When creating the attachment object, pass in the weapon that you want to
	 * decorate (wrap). the weapon is stored in an instance variable we define in
	 * this Abstract Class leve for all attachement subclasses
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
	}

	public int getAttachmentNumber()
	{

		return numberAttachments;

	}

}
