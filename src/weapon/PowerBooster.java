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
		 
		float x = (float)weapon.getCurrentAmmo()/weapon.getMaxAmmo();
		float y = 1 + x;
	    int damage = (int) ((int) ((float)weapon.damage() * y));
	    System.out.println("damage" + damage);
	    return damage;
	  
	  }
	 
	 
	}  
