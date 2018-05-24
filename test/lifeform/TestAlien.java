package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlien
{

	@Test
	public void testInitialize()
	{
		Alien entity = new Alien("burnaby", 200);
		assertEquals("burnaby", entity.getName());
		assertEquals(200, entity.getCurrentLifePoints());	
	}
	
	@Test
	public void testRecovery() {
		
		//test linear recovery
		//Alien entity2 = new Alien("drogo", 150, linear);
		//assertEquals(linear, entity2.recovery());
		
		//fail("not quite dude");
		
		//test fractional recovery
	}

}
