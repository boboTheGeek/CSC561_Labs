import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all of the tests in this project
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{ TestLifeForm.class, TestCell.class, TestEnvironment.class })

public class AllGameTests
{
  //nothing here yet
}