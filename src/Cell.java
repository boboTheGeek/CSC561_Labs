
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
	 * @param entity - life form instance to add to cell
	 * 
	 * @return true if the LifeForm was added to the Cell, false otherwise.
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (identity == null)
		{
			identity = entity;
			return true;
		}
		else
		{
			return false;
		}

	}

	/*
	 * Removes the LifeForm in the Cell. Returns the LifeForm removed, null if none
	 * present.
	 * 
	 * @return identity of life form removed else null
	 */
	public LifeForm removeLifeForm()
	{
		if (identity != null)
		{
			LifeForm id = identity;
			identity = null;
			return id;
		}
		else
		{
			return null;
		}

	}
}
