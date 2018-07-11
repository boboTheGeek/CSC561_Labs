
/**
 * Test Suite for full game
 * Author: Rob Miles, Chandana G
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import gameplay.TestSimulator;
import lifeform.TestAlien;
import lifeform.TestHuman;
import lifeform.TestLifeForm;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import state.TestAI;
import state.TestDeadState;
import state.TestHasNoWeapon;
import state.TestHasWeaponState;
import state.TestOutOfAmmoState;
import ui.TestGameDisplay;
import ui.command.TestAcquire;
import ui.command.TestAttack;
import ui.command.TestDrop;
import ui.command.TestInvoker;
import ui.command.TestInvokerBuilder;
import ui.command.TestMove;
import ui.command.TestReload;
import ui.command.TestTurnEast;
import ui.command.TestTurnNorth;
import ui.command.TestTurnSouth;
import ui.command.TestTurnWest;
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
@Suite.SuiteClasses({ TestLifeForm.class, TestCell.class, TestEnvironment.class, TestHuman.class, TestAlien.class,
		TestRecoveryNone.class, TestRecoveryLinear.class, TestRecoveryFractional.class, TestSimpleTimer.class,
		TestChainGun.class, TestGenericWeapon.class, TestPistol.class, TestPlasmaCannon.class, TestPowerBooster.class,
		TestScope.class, TestAcquire.class, TestAttack.class, TestDrop.class, TestInvoker.class,
		TestInvokerBuilder.class, TestMove.class, TestReload.class, TestTurnEast.class, TestTurnNorth.class,
		TestTurnSouth.class, TestTurnWest.class, TestHasNoWeapon.class, TestHasWeaponState.class,
		TestOutOfAmmoState.class, TestDeadState.class, TestSimulator.class, TestAI.class, TestGameDisplay.class  })

public class AllGameTests
{
	// nothing here yet

}
