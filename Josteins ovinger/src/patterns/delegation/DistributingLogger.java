package patterns.delegation;

public class DistributingLogger implements ILogger {
	
	private ILogger errorLogger, warningLogger, infoLogger;
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger;
		this.infoLogger = infoLogger;
	}
	public void setLogger(String severity, ILogger logger) {
		if(severity.equals(ILogger.ERROR))
			this.errorLogger = logger;
		else if(severity.equals(ILogger.WARNING))
			this.warningLogger = logger;
		else if(severity.equals(ILogger.INFO))
			this.infoLogger = logger;
	}
	@Override
	public void log(String severity, String message, Exception exception) {
		if (severity.equals(ILogger.ERROR))
			errorLogger.log(severity, message, exception);
		
		else if (severity.equals(ILogger.WARNING))
			warningLogger.log(severity, message, exception);
		
		else if (severity.equals(ILogger.INFO))
			infoLogger.log(severity, message, exception);
	}

}
