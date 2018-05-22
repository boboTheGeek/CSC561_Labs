
/**
 * A Cell that can hold a LifeForm.
 *
 */
public class Cell
{

	protected LifeForm identity;

	/**
	 * @return the LifeForm in this Cell.
	 */
	public LifeForm getLifeForm()
	{
		return identity;
	}

	/**
	 * Tries to add the LifeForm to the Cell. Will not add if a LifeForm is already
	 * present.
	 * 
	 * @return true if the LifeForm was added to the Cell, false otherwise.
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (identity == null)
		{
			identity = entity;
			return true;
		} else
		{
			return false;
		}

	}
}
