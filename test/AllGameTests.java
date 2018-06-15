/**
 * Test Suite for full game
 * Author: Rob Miles, Chandana G
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import lifeform.TestAlien;
import lifeform.TestHuman;
import lifeform.TestLifeForm;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import weapon.TestChainGun;
import weapon.TestGenericWeapon;
import weapon.TestPistol;
import weapon.TestPlasmaCannon;
import weapon.TestPowerBooster;
import weapon.TestScope;

//nochange
/**
 * Runs all of the tests in this project
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{ 		TestLifeForm.class, 
		TestCell.class, 
		TestEnvironment.class, 
		TestHuman.class, 
		TestAlien.class, 
		TestRecoveryNone.class,
		TestRecoveryLinear.class, 
		TestRecoveryFractional.class, 
		TestSimpleTimer.class, 
		TestChainGun.class, 
		TestGenericWeapon.class, 
		TestPistol.class, 
		TestPlasmaCannon.class, 
		TestPowerBooster.class,
		TestScope.class 
})

public class AllGameTests
{
	// nothing here yet

}
