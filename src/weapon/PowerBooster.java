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
	    int damage = (int) ((int)weapon.damage() * (float)( 1 + (float)(weapon.getCurrentAmmo()/weapon.getMaxAmmo())));
	    System.out.println("damage" + damage);
	 
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
