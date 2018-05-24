/*
 * Test Suite for full game
 * Author: Rob Miles
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;
import lifeform.TestAlien;
import lifeform.TestHuman;
import lifeform.TestLifeForm;
//nochange
/**
 * Runs all of the tests in this project
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{ TestLifeForm.class, TestCell.class, TestEnvironment.class, TestHuman.class, TestAlien.class })

public class AllGameTests
{
  //nothing here yet
	
	
}
