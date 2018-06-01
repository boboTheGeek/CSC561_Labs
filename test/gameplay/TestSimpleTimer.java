/**
 * Unit testing for simple timer module, it tests:
 * 
 * 		initializes correctly
 * 		updates time correctly
 * 		able to add observers
 * 		able to remove observers
 * 		observers recieve time update
 * 		updates time correctly as thread
 * 		able to sleep the thread
 * 		uses a mock object to test observable
 * 
 * @Author: Rob Miles
 */

package gameplay;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimpleTimer
{

	@Test //initializes correctly
	public void testInit()
	{
		SimpleTimer masterTimer = new SimpleTimer();
		TimeObserver DrZoidberg = new MockSimpleTimerObserver();
		masterTimer.addTimeObserver(DrZoidberg);
		assertEquals(DrZoidberg, masterTimer.getObserver());
	}
	
	@Test
	public void testTimeChanged()
	{
		SimpleTimer masterTimer = new SimpleTimer();
		TimeObserver newObserver1 = new MockSimpleTimerObserver();
		TimeObserver newObserver2 = new MockSimpleTimerObserver();
		TimeObserver newObserver3 = new MockSimpleTimerObserver(); 
		masterTimer.addTimeObserver(newObserver1);
		masterTimer.addTimeObserver(newObserver2);
		masterTimer.addTimeObserver(newObserver3);
		masterTimer.timeChanged();
		assertEquals(3, ((MockSimpleTimerObserver) newObserver3).getTime());
	}
	
	@Test
	public void testAddTimeObserver()
	{
		TimeObserver newObserver = new MockSimpleTimerObserver();
		SimpleTimer masterTimer = new MockSimpleTimer();
		masterTimer.addTimeObserver(newObserver);
		assertEquals(newObserver, masterTimer.getObserver());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveTimeObserver()
	{
		TimeObserver newObserver = new MockSimpleTimerObserver();
		SimpleTimer masterTimer = new MockSimpleTimer();
		masterTimer.addTimeObserver(newObserver);
		masterTimer.removeTimeObserver(newObserver);
		assertEquals(newObserver, masterTimer.getObserver());
	}



	/**
	 * This tests that SimpleTimer will update time once every second.
	 * 
	 * @Test public void testSimpleTimerAsThread() throws InterruptedException {
	 *       SimpleTimer st = new SimpleTimer(1000); st.start(); Thread.sleep(250);
	 *       // So we are 1/4th a second different for (int x = 0; x < 5; x++) {
	 *       assertEquals(x, st.getRound()); // assumes round starts at 0
	 *       Thread.sleep(1000); // wait for the next time change } }
	 */

}

class MockSimpleTimerObserver implements TimeObserver
{
	public int myTime = 0;

	public void updateTime(int time)
	{
		myTime = time;
		
	}
	public int getTime()
	{
		return myTime;			
	}

}

class MockSimpleTimer extends SimpleTimer
{

}
