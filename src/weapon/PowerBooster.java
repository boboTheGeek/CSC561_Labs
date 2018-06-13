package weapon;

public class PowerBooster extends Attachment
{
	GenericWeapon gw;
	PowerBooster(Weapon w) 
	{
		super(w);
		
	}

	 public int damage()
	 
	  {
		 
		/*float x = weapon.getCurrentAmmo()/weapon.getMaxAmmo();
		float y = 1 + x;
		System.out.println(x + "..." + y);
	    int damage = (int) ((int) weapon.damage() * y);
	    
	    System.out.println("damage" + damage);
	 */
		int damage = (int) ((int) weapon.damage() * (1 + (weapon.getCurrentAmmo()/weapon.getMaxAmmo())));
	    return damage;
	  
	  }
	 
	  @Override
	 
	  public int getMaxAmmo() 
	  {
	 
	    // TODO Auto-generated method stub
	 
	    return 0;
	 
	  }

	  @Override
	 
	  public int getMaxRange()
	  {
	 
	    // TODO Auto-generated method stub
	 
	    return 0;
	 
	  }
	 
	  @Override
	 
	  public void updateTime(int time)
	  {
	    
	 
	  }

	@Override
	public int getCurrentAmmo() {
		// TODO Auto-generated method stub
		return 0;
	}
	 
	}  
