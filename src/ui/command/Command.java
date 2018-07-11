/**
 * @Author Chandana G
 * Interface for all the commands (Reload, Acquire, Attack, Drop, Move)
 */

package ui.command;

import exceptions.EnvironmentException;
import exceptions.RException;

public interface Command {
	
	public void execute() throws RException, EnvironmentException;

}
