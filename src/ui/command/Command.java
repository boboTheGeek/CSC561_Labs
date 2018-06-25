/**
 * @Author Chandana G
 */

package ui.command;

import exceptions.EnvironmentException;
import exceptions.RException;

public interface Command {
	
	public void execute() throws RException, EnvironmentException;

}
