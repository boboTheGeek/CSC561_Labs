/*
 * Test Suite for full game
 * Author: Rob Miles
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;
import lifeform.TestHuman;
import lifeform.TestLifeForm;
//nochange
/**
 * Runs all of the tests in this project
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{ TestLifeForm.class, TestCell.class, TestEnvironment.class, TestHuman.class })

public class AllGameTests
{
  //nothing here yet
	
	
}
