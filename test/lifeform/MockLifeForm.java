package lifeform;

public class MockLifeForm extends LifeForm
{
	public MockLifeForm(String name, int points)
	{
		super(name, points);
		maxSpeed = 3;
	}
	
	public MockLifeForm(String name, int points, int attstr)
	{
		super(name, points, attstr);
		maxSpeed = 3;
	}
	
	public int getMaxLife()
	{
		return maxLifePoints;
	}
}
//