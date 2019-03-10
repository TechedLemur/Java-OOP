package patterns.delegation;

import java.util.ArrayList;
import java.util.Arrays;

public class FilteringLogger implements ILogger{
	
	private ArrayList<String> severities;
	private ILogger logger;
	
	public FilteringLogger(ILogger logger, String... severities) {
		this.severities = new ArrayList<String>(Arrays.asList(severities));
		this.logger = logger;
	}
	@Override
	public void log(String severity, String message, Exception exception) {
		if (this.isLogging(severity))
			logger.log(severity, message, exception);
	}
	
	public boolean isLogging(String severity) {
		return severities.contains(severity);
	}
	
	public void setIsLogging(String severity, boolean value) {
		if (value && !this.severities.contains(severity))
			this.severities.add(severity);
		else
			this.severities.remove(severity);
	}
}
