/**
 * MockLifeForm for testing lifeform
 * @Author: Rob Miles
 */

package lifeform;

public class MockLifeForm extends LifeForm
{
	/**
	 * used for testing lifeform class
	 * 
	 * @param name the name of the life form to be
	 * @param points the number of current life points
	 * @param atStr sets attack strength
	 */
	public MockLifeForm(String name, int points, int atStr)
	{
		super(name, points, atStr);
	}
	
	public MockLifeForm(String name, int points)
	{
		this(name, points, 0);
	}


}