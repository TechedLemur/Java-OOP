package patterns.delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger{
	
	private OutputStream stream;
	private String formatString = "%s: %s (%s)";
	public StreamLogger(OutputStream stream) {
		this.stream = stream;
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		String logMessage = String.format(formatString, severity, message, exception);
		try {
			stream.write(logMessage.getBytes());
			stream.flush();
		} catch (IOException e) {
		}
	}
	
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
}
