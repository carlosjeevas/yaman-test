package selenium.command;

import org.openqa.selenium.WebDriver;

public enum CommandType {

	WEB {
		@Override
		public CommandAction getCommand(WebDriver webDriver) {
			return new CommandActionWeb(webDriver);
		}
	};

	/**
	 * get command
	 * 
	 * @param webDriver
	 * @return
	 */
	public abstract CommandAction getCommand(WebDriver webDriver);

	public static CommandAction getCommand(CommandType commandType, WebDriver webDriver) {
		return commandType.getCommand(webDriver);
	}
}